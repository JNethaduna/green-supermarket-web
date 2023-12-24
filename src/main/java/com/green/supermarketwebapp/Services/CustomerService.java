package com.green.supermarketwebapp.services;

import java.util.NoSuchElementException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.green.supermarketwebapp.daos.CustomerDAO;
import com.green.supermarketwebapp.models.Customer;

@Service
public class CustomerService {
  private final CustomerDAO customerRepository;
  private final PasswordEncoder passwordEncoder;

  public CustomerService(CustomerDAO customerRepository, PasswordEncoder passwordEncoder) {
    this.customerRepository = customerRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public Customer getCustomer(Long id) {
    return customerRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Customer not found"));
  }

  public Customer getCustomer(String email) {
    return customerRepository.findByEmail(email).orElseThrow(() -> new NoSuchElementException("Customer not found"));
  }

  public Customer createCustomer(Customer customer) {
    customer.setPassword(passwordEncoder.encode(customer.getPassword()));
    return customerRepository.save(customer);
  }

  public void deleteCustomer(Long id) {
    customerRepository.deleteById(id);
  }
}
