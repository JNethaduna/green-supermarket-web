package com.green.supermarketwebapp.cart;

import com.green.supermarketwebapp.customer.Customer;
import com.green.supermarketwebapp.product.Product;

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
}
