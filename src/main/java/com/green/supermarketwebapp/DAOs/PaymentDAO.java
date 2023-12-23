package com.green.supermarketwebapp.DAOs;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.supermarketwebapp.Models.Payment;

public interface PaymentDAO extends JpaRepository<Payment, Long> {

}
