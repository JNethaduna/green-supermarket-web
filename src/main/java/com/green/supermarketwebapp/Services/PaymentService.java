package com.green.supermarketwebapp.Services;

import java.sql.Timestamp;

import org.springframework.stereotype.Service;

import com.green.supermarketwebapp.DAOs.PaymentDAO;
import com.green.supermarketwebapp.Models.Payment;
import com.green.supermarketwebapp.Models.PaypalPayment;

@Service
public class PaymentService {
  private final PaymentDAO paymentRepository;

  public PaymentService(PaymentDAO paymentRepository) {
    this.paymentRepository = paymentRepository;
  }

  public Payment createPayment(String paymentId, String payerId, double amount) {
    PaypalPayment payment = new PaypalPayment();
    payment.setMethod("Paypal");
    payment.setAmount(amount);
    payment.setStatus("Completed");
    payment.setCompletedAt(new Timestamp(System.currentTimeMillis()));
    payment.setPaypalPaymentId(paymentId);
    payment.setPaypalPayerId(payerId);

    return paymentRepository.save(payment);
  }

  public Payment createPayment(double amount) {
    Payment payment = new Payment();
    payment.setMethod("Other");
    payment.setAmount(amount);
    payment.setStatus("Completed");
    payment.setCompletedAt(new Timestamp(System.currentTimeMillis()));

    return paymentRepository.save(payment);
  }
}
