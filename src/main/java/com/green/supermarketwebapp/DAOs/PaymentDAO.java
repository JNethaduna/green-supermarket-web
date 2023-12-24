package com.green.supermarketwebapp.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.supermarketwebapp.models.Payment;

public interface PaymentDAO extends JpaRepository<Payment, Long> {

}
