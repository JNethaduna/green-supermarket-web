package com.green.supermarketwebapp.controllers;

import java.util.Date;
import java.util.Calendar;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.supermarketwebapp.exceptions.InsufficientStockException;
import com.green.supermarketwebapp.models.Order;
import com.green.supermarketwebapp.services.CartService;
import com.green.supermarketwebapp.services.OrderService;
import com.green.supermarketwebapp.services.UserContextService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class OrderController {
  private final OrderService orderService;
  private final CartService cartService;
  private final UserContextService userContextService;

  public OrderController(OrderService orderService, CartService cartService,
      UserContextService userContextService) {
    this.orderService = orderService;
    this.cartService = cartService;
    this.userContextService = userContextService;
  }

  @GetMapping("/user/order/{id}")
  public String getOrder(Model model, @PathVariable Long id) {
    Order order = orderService.getOrder(id);
    model.addAttribute("order", order);
    return "order";
  }

  @GetMapping("/user/order/list")
  public String getOrderList(Model model,
      @RequestParam(defaultValue = "") String status,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "50") int size) {
    model.addAttribute("orders", orderService.getOrders(status, page, size));
    return "order-list";
  }

  @GetMapping("/user/checkout")
  public String checkout(Model model) {
    try {
      orderService.beginCheckout();
    } catch (InsufficientStockException e) {
      model.addAttribute("message", e.getMessage());
      return "error";
    } catch (Exception e) {
      model.addAttribute("message", e.getMessage());
      return "error";
    }
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DATE, 3);
    Date deliveryDate = cal.getTime();

    model.addAttribute("cartItems", cartService.getSelected(userContextService.getCurrentCustomer()));
    model.addAttribute("subtotal", cartService.getTotal());
    model.addAttribute("customer", userContextService.getCurrentCustomer());
    model.addAttribute("delivery", deliveryDate);
    return "checkout";
  }

  @GetMapping("/manage/order/list")
  public String getManageOrderList(Model model,
      @RequestParam(defaultValue = "Processing") String status,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "50") int size) {
    model.addAttribute("orders", orderService.getOrderList(status, page, size));
    return "orders-manager-view";
  }

  @GetMapping("/manage/order/update")
  public String getUpdateOrderStatus() {
    return "order-status-update";
  }

  @PostMapping("/manage/order/update")
  public ResponseEntity<String> updateStatus(@RequestBody Long id, @RequestBody String status) {
    orderService.updateOrderStatus(id, status);
    return ResponseEntity.ok("Status updated");
  }

}
