package com.green.supermarketwebapp.DAOs;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.supermarketwebapp.Models.Customer;

public interface CustomerDAO extends JpaRepository<Customer, Long> {
  Optional<Customer> findByEmail(String email);
}
