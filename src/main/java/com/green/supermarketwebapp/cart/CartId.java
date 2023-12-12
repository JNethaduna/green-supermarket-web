package com.green.supermarketwebapp.cart;

import java.io.Serializable;
import java.util.Objects;

public class CartId implements Serializable {
  private Long customer;
  private Long product;

  public CartId() {
  }

  public CartId(Long customer, Long product) {
    this.customer = customer;
    this.product = product;
  }

  public Long getCustomer() {
    return customer;
  }

  public Long getProduct() {
    return product;
  }

  public void setCustomer(Long customer) {
    this.customer = customer;
  }

  public void setProductId(Long product) {
    this.product = product;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    CartId cartId = (CartId) o;
    return Objects.equals(customer, cartId.customer) && Objects.equals(product, cartId.product);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customer, product);
  }
}
