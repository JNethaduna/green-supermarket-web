package com.green.supermarketwebapp.Services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

import java.net.http.HttpRequest;
import org.springframework.stereotype.Service;

@Service
public class PaypalPaymentService {
  private HttpClient client = HttpClient.newHttpClient();

  public String createOrder(String orderJson, String accessToken) throws Exception {
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("https://api.sandbox.paypal.com/v2/checkout/orders"))
        .header("Content-Type", "application/json")
        .header("Authorization", "Bearer " + accessToken)
        .POST(HttpRequest.BodyPublishers.ofString(orderJson))
        .build();
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    return response.body();
  }

  public String captureOrder(String orderId, String accessToken) throws Exception {
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("https://api.sandbox.paypal.com/v2/checkout/orders/" + orderId + "/capture"))
        .header("Content-Type", "application/json")
        .header("Authorization", "Bearer " + accessToken)
        .POST(HttpRequest.BodyPublishers.noBody())
        .build();
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    return response.body();
  }
}
