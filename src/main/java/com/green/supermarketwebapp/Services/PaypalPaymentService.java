package com.green.supermarketwebapp.services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.Base64;
import java.net.http.HttpRequest;

import org.json.JSONArray;
import org.springframework.stereotype.Service;

import com.green.supermarketwebapp.config.PaypalConfig;

@Service
public class PaypalPaymentService {
  private final PaypalConfig paypalConfig;
  private final Helpers helpers;
  private HttpClient client = HttpClient.newHttpClient();

  public PaypalPaymentService(PaypalConfig paypalConfig, Helpers helpers) {
    this.paypalConfig = paypalConfig;
    this.helpers = helpers;
  }

  public String createOrder(String orderJson, String accessToken) throws Exception {
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(paypalConfig.getBaseUrl() + "/v2/checkout/orders"))
        .header("Content-Type", "application/json")
        .header("Authorization", "Bearer " + accessToken)
        .POST(HttpRequest.BodyPublishers.ofString(orderJson))
        .build();
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    return response.body();
  }

  public String captureOrder(String orderId, String accessToken) throws Exception {
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(paypalConfig.getBaseUrl() + "/v2/checkout/orders/" + orderId + "/capture"))
        .header("Content-Type", "application/json")
        .header("Authorization", "Bearer " + accessToken)
        .POST(HttpRequest.BodyPublishers.noBody())
        .build();
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    return response.body();
  }

  public String createOrderJson(String price) {
    return "{" +
        "  \"intent\": \"CAPTURE\"," +
        "  \"purchase_units\": [" +
        "    {" +
        "      \"amount\": {" +
        "        \"currency_code\": \"LKR\"," +
        "        \"value\": \"" + price + "\"" +
        "      }" +
        "    }" +
        "  ]" +
        "  \"application_context\": {" +
        "    \"return_url\": \"http://localhost:8080/payment/complete\"," +
        "    \"cancel_url\": \"http://localhost:8080/payment/canceled\"" +
        "  }" +
        "}";
  }

  public String getAccessToken() throws Exception {
    String auth = paypalConfig.getClientId() + ":" + paypalConfig.getSecret();
    String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());

    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(paypalConfig.getBaseUrl() + "/v1/oauth2/token"))
        .header("Content-Type", "application/x-www-form-urlencoded")
        .header("Authorization", "Basic " + encodedAuth)
        .POST(HttpRequest.BodyPublishers.ofString("grant_type=client_credentials"))
        .build();

    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

    return helpers.parseJson(response.body()).getString("access_token");
  }

  public String getApproveLink(String order) throws Exception {
    JSONArray links = helpers.parseJson(order).getJSONArray("links");
    for (int i = 0; i < links.length(); i++) {
      if (links.getJSONObject(i).getString("rel").equals("approve")) {
        return links.getJSONObject(i).getString("href");
      }
    }
    throw new Exception("Approve link not found");
  }

  // Follwing two methods assume that there is only one purchase unit and one
  // capture.
  // If there is a possibility for multiple, please adjust the code accordingly.
  public String getPaymentId(String response) throws Exception {
    return helpers.parseJson(response)
        .getJSONArray("purchase_units")
        .getJSONObject(0) // First purchase unit
        .getJSONObject("payments")
        .getJSONArray("captures")
        .getJSONObject(0) // First capture
        .getString("id");
  }

  public double getAmount(String response) throws Exception {
    String value = helpers.parseJson(response)
        .getJSONArray("purchase_units")
        .getJSONObject(0) // First purchase unit
        .getJSONObject("payments")
        .getJSONArray("captures")
        .getJSONObject(0) // First capture
        .getJSONObject("amount")
        .getString("value");

    return Double.parseDouble(value);
  }

  public String getPayerId(String response) throws Exception {
    return helpers.parseJson(response)
        .getJSONObject("payer")
        .getString("payer_id");
  }
}
