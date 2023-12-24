package com.green.supermarketwebapp.services;

import java.sql.Timestamp;

import org.springframework.stereotype.Service;

import com.green.supermarketwebapp.daos.PaymentDAO;
import com.green.supermarketwebapp.models.Payment;
import com.green.supermarketwebapp.models.PaypalPayment;

@Service
public class PaymentService {
  private final PaymentDAO paymentRepository;

  public PaymentService(PaymentDAO paymentRepository) {
    this.paymentRepository = paymentRepository;
  }

  public Payment createPaypalPayment(String paymentId, String payerId, double amount) {
    PaypalPayment payment = new PaypalPayment();
    payment.setMethod("Paypal");
    payment.setAmount(amount);
    payment.setStatus("Completed");
    payment.setCompletedAt(new Timestamp(System.currentTimeMillis()));
    payment.setPaypalPaymentId(paymentId);
    payment.setPaypalPayerId(payerId);

    return paymentRepository.save(payment);
  }
}
