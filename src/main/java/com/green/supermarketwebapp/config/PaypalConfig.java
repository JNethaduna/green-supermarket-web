package com.green.supermarketwebapp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("paypal")
public class PaypalConfig {
  private String clientId;
  private String secret;
  private String baseUrl;

  public String getClientId() {
    return clientId;
  }

  public String getSecret() {
    return secret;
  }

  public String getBaseUrl() {
    return baseUrl;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public void setSecret(String secret) {
    this.secret = secret;
  }

  public void setBaseUrl(String baseUrl) {
    this.baseUrl = baseUrl;
  }
}
