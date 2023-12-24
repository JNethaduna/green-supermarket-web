package com.green.supermarketwebapp.services;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.green.supermarketwebapp.daos.OrderDAO;
import com.green.supermarketwebapp.exceptions.OrderNotFoundException;
import com.green.supermarketwebapp.models.Cart;
import com.green.supermarketwebapp.models.Customer;
import com.green.supermarketwebapp.models.Order;
import com.green.supermarketwebapp.models.OrderDetails;

@Service
public class OrderService {
  private final OrderDAO orderRepository;
  private final UserContextService userContextService;
  private final CartService cartService;
  private final PaymentService paymentService;
  private final OrderDetailsService orderDetailsService;
  private final MailService mailService;

  public OrderService(
      OrderDAO orderRepository,
      UserContextService userContextService,
      CartService cartService,
      PaymentService paymentService,
      OrderDetailsService orderDetailsService,
      MailService mailService) {
    this.orderRepository = orderRepository;
    this.userContextService = userContextService;
    this.cartService = cartService;
    this.paymentService = paymentService;
    this.orderDetailsService = orderDetailsService;
    this.mailService = mailService;
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

  public Order placeOrder(String paymentId, String payerId, double amount) {
    Customer customer = userContextService.getCurrentCustomer();

    // Creating a new order
    Order order = new Order();
    order.setCustomer(customer);
    order.setStatus("Processing");
    order.setPayment(paymentService.createPaypalPayment(paymentId, payerId, amount));

    // Saving the order to the database to be used in the order details
    order = orderRepository.save(order);

    // Creating order details for the order from the selected cart items
    List<Cart> selectedItems = cartService.getSelected(customer);
    List<OrderDetails> orderDetails = orderDetailsService.createOrderDetails(selectedItems, order);
    orderDetailsService.saveOrderDetails(orderDetails);

    // Deleting the selected cart items
    cartService.removeAllFromCart(selectedItems);

    // Sending the order confirmation email
    mailService.sendMail(userContextService.getCurrentUserEmail(), "Order Confirmation",
        "Your order has been placed successfully.");

    return order;
  }

  public Order updateOrderStatus(Long id, String status) {
    Order order = getOrder(id);
    order.setStatus(status);
    order = orderRepository.save(order);

    mailService.sendMail(userContextService.getCurrentUserEmail(), "Order Status Update",
        "Your order status has been updated to " + status + ".");

    return order;
  }
}
