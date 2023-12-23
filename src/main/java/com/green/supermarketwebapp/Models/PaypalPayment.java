package com.green.supermarketwebapp.Models;

public class PaypalPayment extends Payment {
  private String paypalPaymentId;
  private String paypalPayerId;

  // Setters
  public void setPaypalPaymentId(String paypalPaymentId) {
    this.paypalPaymentId = paypalPaymentId;
  }

  public void setPaypalPayerId(String paypalPayerId) {
    this.paypalPayerId = paypalPayerId;
  }

  // Getters
  public String getPaypalPaymentId() {
    return paypalPaymentId;
  }

  public String getPaypalPayerId() {
    return paypalPayerId;
  }
}
