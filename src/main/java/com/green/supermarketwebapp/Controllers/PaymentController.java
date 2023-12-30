package com.green.supermarketwebapp.controllers;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.green.supermarketwebapp.services.CartService;
import com.green.supermarketwebapp.services.Helpers;
import com.green.supermarketwebapp.services.OrderService;
import com.green.supermarketwebapp.services.PaypalPaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaymentController {
  private final PaypalPaymentService paypalPaymentService;
  private final OrderService orderService;
  private final CartService cartService;

  public PaymentController(PaypalPaymentService paypalPaymentService, OrderService orderService,
      CartService cartService) {
    this.paypalPaymentService = paypalPaymentService;
    this.orderService = orderService;
    this.cartService = cartService;
  }

  @PostMapping("/payment/paypal/start")
  public String startPaypalPayment(Model model) {
    try {
      String accessToken = paypalPaymentService.getAccessToken();
      String orderJson = paypalPaymentService.createOrderJson(Helpers.LKRtoUSD(cartService.getTotal()));
      String order = paypalPaymentService.createOrder(orderJson, accessToken);
      return "redirect:" + paypalPaymentService.getApproveLink(order);
    } catch (Exception e) {
      model.addAttribute("message", e.getMessage());
      return "error";
    }
  }

  @GetMapping("/payment/paypal/complete")
  public String completePaypalPayment(@RequestParam("token") String token, Model model) {
    try {
      String accessToken = paypalPaymentService.getAccessToken();
      String response = paypalPaymentService.captureOrder(token, accessToken);
      String paymentId = paypalPaymentService.getPaymentId(response);
      String payerId = paypalPaymentService.getPayerId(response);
      double amount = paypalPaymentService.getAmount(response);
      orderService.placeOrder(paymentId, payerId, amount);
      Calendar cal = Calendar.getInstance();
      cal.add(Calendar.DATE, 3);
      Date deliveryDate = cal.getTime();
      model.addAttribute("delivery", deliveryDate);
      return "order-successful";
    } catch (Exception e) {
      model.addAttribute("message",
          e.getMessage());
      return "error";
    }
  }

  @GetMapping("/payment/paypal/canceled")
  public String cancelPaypalPayment() {
    return "redirect:/payment/canceled";
  }
}
