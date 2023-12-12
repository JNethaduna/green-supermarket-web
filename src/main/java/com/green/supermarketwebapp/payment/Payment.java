package com.green.supermarketwebapp.payment;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Payment {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_seq")
  @SequenceGenerator(name = "payment_seq", sequenceName = "payment_seq", allocationSize = 1, initialValue = 1000000000)
  private Long id;

  private double amount;
  private String method;
  private String status;
  private Timestamp completedAt;

  // Setters
  public void setAmount(double amount) {
    this.amount = amount;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public void setCompletedAt(Timestamp completedAt) {
    this.completedAt = completedAt;
  }

  // Getters
  public Long getId() {
    return id;
  }

  public double getAmount() {
    return amount;
  }

  public String getMethod() {
    return method;
  }

  public String getStatus() {
    return status;
  }

  public Timestamp getCompletedTime() {
    return completedAt;
  }
}
