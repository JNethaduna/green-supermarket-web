package com.green.supermarketwebapp.models.keys;

import java.io.Serializable;
import java.util.Objects;

public class OrderDetailsId implements Serializable {
  public Long order;
  public Long product;

  public OrderDetailsId() {
  }

  public OrderDetailsId(Long order, Long product) {
    this.order = order;
    this.product = product;
  }

  public Long getOrder() {
    return order;
  }

  public Long getProduct() {
    return product;
  }

  public void setOrder(Long order) {
    this.order = order;
  }

  public void setProduct(Long product) {
    this.product = product;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    OrderDetailsId orderDetailsId = (OrderDetailsId) o;
    return Objects.equals(order, orderDetailsId.order) && Objects.equals(product, orderDetailsId.product);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(order, product);
  }
}
