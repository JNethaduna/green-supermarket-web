package com.green.supermarketwebapp.models.keys;

import java.util.Objects;

public class StockLockId {
  private Long customer;
  private Long product;

  public StockLockId() {
  }

  public StockLockId(Long customer, Long product) {
    this.customer = customer;
    this.product = product;
  }

  // Setters

  public void setCustomer(Long customer) {
    this.customer = customer;
  }

  public void setProduct(Long product) {
    this.product = product;
  }

  // Getters

  public Long getCustomer() {
    return customer;
  }

  public Long getProduct() {
    return product;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    StockLockId stockLockId = (StockLockId) o;
    return Objects.equals(customer, stockLockId.customer) && Objects.equals(product, stockLockId.product);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customer, product);
  }
}
