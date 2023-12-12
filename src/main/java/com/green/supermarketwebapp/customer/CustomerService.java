package com.green.supermarketwebapp.customer;

import java.util.NoSuchElementException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
  private final CustomerRepository customerRepository;
  private final PasswordEncoder passwordEncoder;

  public CustomerService(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
    this.customerRepository = customerRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public Customer getCustomer(Long id) {
    return customerRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Customer not found"));
  }

  public Customer getCustomer(String email) {
    return customerRepository.findByEmail(email).orElseThrow(() -> new NoSuchElementException("Customer not found"));
  }

  public void createCustomer(Customer customer) {
    customer.setPassword(passwordEncoder.encode(customer.getPassword()));
    customerRepository.save(customer);
  }

  public void deleteCustomer(Long id) {
    customerRepository.deleteById(id);
  }
}
