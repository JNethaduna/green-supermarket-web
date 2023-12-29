package com.green.supermarketwebapp.services;

import java.util.List;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.green.supermarketwebapp.daos.OrderDAO;
import com.green.supermarketwebapp.exceptions.InsufficientStockException;
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
  private final ProductService productService;
  private final StockLockService stockLockService;

  public OrderService(
      OrderDAO orderRepository,
      UserContextService userContextService,
      CartService cartService,
      PaymentService paymentService,
      OrderDetailsService orderDetailsService,
      MailService mailService,
      ProductService productService,
      StockLockService stockLockService) {
    this.orderRepository = orderRepository;
    this.userContextService = userContextService;
    this.cartService = cartService;
    this.paymentService = paymentService;
    this.orderDetailsService = orderDetailsService;
    this.mailService = mailService;
    this.productService = productService;
    this.stockLockService = stockLockService;
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

  public List<Order> getOrderList(String status, int page, int size) {
    return orderRepository.findByStatus(status, PageRequest.of(page, size)).getContent();
  }

  @Transactional
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
    order.setOrderDetails(orderDetails);

    order = orderRepository.save(order);

    // Deleting the selected cart items
    for (Cart item : selectedItems) {
      cartService.removeFromCart(item.getProduct().getId());
    }

    // Cleaning up stock locks and decreasing main stock
    for (Cart item : selectedItems) {
      productService.decreaseStock(item.getProduct().getId(), item.getQuantity());
    }
    stockLockService.deleteCustomerStockLocks(customer);

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

  @Transactional
  public void beginCheckout() {
    int attempts = 0;
    while (attempts < 3) {
      try {
        Customer customer = userContextService.getCurrentCustomer();
        List<Cart> selectedItems = cartService.getSelected(customer);
        for (Cart item : selectedItems) {
          Integer stock = productService.checkAvailableStock(item.getProduct().getId());
          if (stock < item.getQuantity()) {
            throw new InsufficientStockException("Not enough stock available for " + item.getProduct().getName());
          }
          stockLockService.createStockLock(customer, item.getProduct(), item.getQuantity());
        }
        break;
      } catch (OptimisticLockingFailureException e) {
        if (++attempts >= 3) {
          throw e;
        }
      }
    }

  }
}
