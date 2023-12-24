package com.green.supermarketwebapp.controllers;

import org.springframework.stereotype.Controller;

import com.green.supermarketwebapp.services.OrderService;
import com.green.supermarketwebapp.services.PaypalPaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaymentController {
  private final PaypalPaymentService paypalPaymentService;
  private final OrderService orderService;

  public PaymentController(PaypalPaymentService paypalPaymentService, OrderService orderService) {
    this.paypalPaymentService = paypalPaymentService;
    this.orderService = orderService;
  }

  @PostMapping("/payment/paypal/start")
  public String startPaypalPayment() throws Exception {
    String accessToken = paypalPaymentService.getAccessToken();
    String orderJson = paypalPaymentService.createOrderJson("100");
    String order = paypalPaymentService.createOrder(orderJson, accessToken);
    return "redirect:" + paypalPaymentService.getApproveLink(order);
  }

  // TODO: Error handling :(
  @GetMapping("/payment/paypal/complete")
  public String completePaypalPayment(@RequestParam("token") String orderId)
      throws Exception {
    String accessToken = paypalPaymentService.getAccessToken();
    String response = paypalPaymentService.captureOrder(orderId, accessToken);
    String paymentId = paypalPaymentService.getPaymentId(response);
    String payerId = paypalPaymentService.getPayerId(response);
    double amount = paypalPaymentService.getAmount(response);
    orderService.placeOrder(paymentId, payerId, amount);
    return "redirect:/payment/success";

  }

  @GetMapping("/payment/paypal/canceled")
  public String cancelPaypalPayment() {
    return "redirect:/payment/canceled";
  }
}
