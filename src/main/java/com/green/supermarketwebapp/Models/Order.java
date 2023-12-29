package com.green.supermarketwebapp.models;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
  @JoinColumn(name = "payment_id", unique = true)
  private Payment payment;

  @ManyToOne
  @JoinColumn(name = "customer_id")
  private Customer customer;

  private Timestamp placedAt;
  private String status;

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
  private List<OrderDetails> orderDetails;

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

  public void setOrderDetails(List<OrderDetails> orderDetails) {
    this.orderDetails = orderDetails;
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

  public List<OrderDetails> getOrderDetails() {
    return orderDetails;
  }
}
