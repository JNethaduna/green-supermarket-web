package com.green.supermarketwebapp.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.green.supermarketwebapp.daos.OrderDetailsDAO;
import com.green.supermarketwebapp.models.Cart;
import com.green.supermarketwebapp.models.Order;
import com.green.supermarketwebapp.models.OrderDetails;

@Service
public class OrderDetailsService {
  private final OrderDetailsDAO orderDetailsRepository;

  public OrderDetailsService(OrderDetailsDAO orderDetailsRepository) {
    this.orderDetailsRepository = orderDetailsRepository;
  }

  public List<OrderDetails> createOrderDetails(List<Cart> cartItems, Order order) {
    List<OrderDetails> orderDetails = new ArrayList<>();
    for (Cart item : cartItems) {
      OrderDetails details = new OrderDetails();
      details.setOrder(order);
      details.setProduct(item.getProduct());
      details.setQuantity(item.getQuantity());
      details.setPrice(item.getProduct().getPrice());
      orderDetailsRepository.save(details);
      orderDetails.add(details);
    }
    return orderDetails;
  }

  public List<OrderDetails> saveOrderDetails(List<OrderDetails> orderDetails) {
    return orderDetailsRepository.saveAll(orderDetails);
  }
}
