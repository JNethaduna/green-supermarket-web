package com.green.supermarketwebapp.order;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.green.supermarketwebapp.auth.UserContextService;
import com.green.supermarketwebapp.cart.Cart;
import com.green.supermarketwebapp.cart.CartService;
import com.green.supermarketwebapp.customer.Customer;
import com.green.supermarketwebapp.exceptions.OrderNotFoundException;
import com.green.supermarketwebapp.orderdetails.OrderDetails;
import com.green.supermarketwebapp.orderdetails.OrderDetailsService;
import com.green.supermarketwebapp.payment.PaymentService;

@Service
public class OrderService {
  private final OrderRepository orderRepository;
  private final UserContextService userContextService;
  private final CartService cartService;
  private final PaymentService paymentService;
  private final OrderDetailsService orderDetailsService;

  public OrderService(OrderRepository orderRepository, UserContextService userContextService,
      CartService cartService, PaymentService paymentService, OrderDetailsService orderDetailsService) {
    this.orderRepository = orderRepository;
    this.userContextService = userContextService;
    this.cartService = cartService;
    this.paymentService = paymentService;
    this.orderDetailsService = orderDetailsService;
  }

  public Order getOrder(Long id) {
    return orderRepository.findById(id)
        .orElseThrow(() -> new OrderNotFoundException("Order with the Id does not exist"));
  }

  public List<Order> getOrders(String status, int page, int size) {
    Long customerId = userContextService.getCurrentCustomer().getId();
    if (status == null || status.isEmpty()) {
      return orderRepository.findByCustomer_Id(customerId, PageRequest.of(page, size)).getContent();
    } else {
      return orderRepository.findByCustomer_IdAndStatus(customerId, status, PageRequest.of(page, size)).getContent();
    }
  }

  public Order placeOrder(String paymentId, String payerId) {
    Customer customer = userContextService.getCurrentCustomer();
    // Creating a new order
    Order order = new Order();
    order.setCustomer(customer);
    order.setStatus("Processing");
    order.setPayment(paymentService.createPayment(paymentId, payerId, cartService.getTotal()));
    // Saving the order to the database to be used in the order details
    order = orderRepository.save(order);
    // Creating order details for the order from the selected cart items
    List<Cart> selectedItems = cartService.getSelected(customer);
    List<OrderDetails> orderDetails = orderDetailsService.createOrderDetails(selectedItems, order);
    orderDetailsService.saveOrderDetails(orderDetails);
    // Deleting the selected cart items
    cartService.removeAllFromCart(selectedItems);

    return order;
  }
}
