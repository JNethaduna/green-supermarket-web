package com.green.supermarketwebapp.Models;

import java.sql.Timestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
  @SequenceGenerator(name = "order_seq", sequenceName = "order_seq", allocationSize = 1, initialValue = 1000000000)
  private Long id;

  @OneToOne(cascade = CascadeType.ALL)
  private Payment payment;

  @ManyToOne
  private Customer customer;

  private Timestamp placedAt;
  private String status;

  @PrePersist
  protected void onCreate() {
    placedAt = new Timestamp(System.currentTimeMillis());
  }

  // Setters
  public void setPayment(Payment payment) {
    this.payment = payment;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  // Getters
  public Long getId() {
    return id;
  }

  public Payment getPayment() {
    return payment;
  }

  public Customer getCustomer() {
    return customer;
  }

  public Timestamp getPlacementTime() {
    return placedAt;
  }

  public String getStatus() {
    return status;
  }
}
