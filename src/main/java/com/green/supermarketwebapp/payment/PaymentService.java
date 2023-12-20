package com.green.supermarketwebapp.payment;

import java.sql.Timestamp;

import org.springframework.stereotype.Service;

import com.green.supermarketwebapp.payment.paypal.PaypalPayment;

@Service
public class PaymentService {
  private final PaymentRepository paymentRepository;

  public PaymentService(PaymentRepository paymentRepository) {
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
