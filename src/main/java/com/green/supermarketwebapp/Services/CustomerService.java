package com.green.supermarketwebapp.services;

import java.util.NoSuchElementException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

  public boolean existingCustomer(String email) {
    return customerRepository.findByEmail(email).isPresent();
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public Customer createCustomer(Customer customer) {
    customer.setPassword(passwordEncoder.encode(customer.getPassword()));
    return customerRepository.save(customer);
  }

  public Customer updateCustomer(Customer customer, Customer currentCustomer) {
    currentCustomer.setFName(customer.getFirstName());
    currentCustomer.setLName(customer.getLastName());
    currentCustomer.setAddress(customer.getAddress());
    currentCustomer.setPhone(customer.getPhone());
    currentCustomer.setPassword(passwordEncoder.encode(customer.getPassword()));
    return customerRepository.save(currentCustomer);
  }

  public void deleteCustomer(Long id) {
    customerRepository.deleteById(id);
  }
}
