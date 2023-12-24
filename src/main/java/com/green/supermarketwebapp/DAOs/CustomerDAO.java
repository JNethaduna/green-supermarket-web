package com.green.supermarketwebapp.daos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.supermarketwebapp.models.Customer;

public interface CustomerDAO extends JpaRepository<Customer, Long> {
  Optional<Customer> findByEmail(String email);
}
