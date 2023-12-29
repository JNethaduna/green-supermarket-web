package com.green.supermarketwebapp.models;

import com.green.supermarketwebapp.models.keys.OrderDetailsId;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@IdClass(OrderDetailsId.class)
public class OrderDetails {
  @Id
  @ManyToOne
  @JoinColumn(name = "order_id")
  private Order order;

  @Id
  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  private int quantity;
  private double price;

  // Setters
  public void setOrder(Order order) {
    this.order = order;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  // Getters
  public Order getOrder() {
    return order;
  }

  public Product getProduct() {
    return product;
  }

  public int getQuantity() {
    return quantity;
  }

  public double getPrice() {
    return price;
  }
}
