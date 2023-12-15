package com.green.supermarketwebapp.orderdetails;

import com.green.supermarketwebapp.order.Order;
import com.green.supermarketwebapp.product.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;

@Entity
@IdClass(OrderDetailsId.class)
public class OrderDetails {
  @Id
  @ManyToOne
  private Order order;

  @Id
  @ManyToOne
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
