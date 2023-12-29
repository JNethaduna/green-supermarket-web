package com.green.supermarketwebapp.models;

import java.sql.Timestamp;

import com.green.supermarketwebapp.models.keys.StockLockId;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

@Entity
@IdClass(StockLockId.class)
public class StockLock {
  @Id
  @ManyToOne
  private Customer customer;
  @Id
  @ManyToOne
  private Product product;

  private int quantity;
  private Timestamp lockedTime;

  public StockLock() {
  }

  public StockLock(Customer customer, Product product, int quantity) {
    this.customer = customer;
    this.product = product;
    this.quantity = quantity;
  }

  // Setters

  @PrePersist
  public void setLockedTime() {
    this.lockedTime = new Timestamp(System.currentTimeMillis());
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  // Getters

  public Customer getCustomer() {
    return customer;
  }

  public Product getProduct() {
    return product;
  }

  public int getQuantity() {
    return quantity;
  }

  public Timestamp getLockedTime() {
    return lockedTime;
  }
}
