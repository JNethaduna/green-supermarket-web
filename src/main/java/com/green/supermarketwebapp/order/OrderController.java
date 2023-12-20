package com.green.supermarketwebapp.order;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {
  private final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
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
}
