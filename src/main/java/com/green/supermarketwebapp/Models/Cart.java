package com.green.supermarketwebapp.Models;

import com.green.supermarketwebapp.Models.Keys.CartId;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;

@Entity
@IdClass(CartId.class)
public class Cart {
  @Id
  @ManyToOne
  private Customer customer;

  @Id
  @ManyToOne
  private Product product;

  private int quantity;
  private boolean selected;

  public Cart() {
  }

  public Cart(Customer customer, Product product, int quantity) {
    this.customer = customer;
    this.product = product;
    this.quantity = quantity;
  }

  // Setters
  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public void setSelected(boolean selected) {
    this.selected = selected;
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

  public boolean isSelected() {
    return selected;
  }
}
