package com.green.supermarketwebapp.services;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.green.supermarketwebapp.exceptions.UserNotLoggedInException;
import com.green.supermarketwebapp.models.Customer;

@Service
public class UserContextService {
  private final CustomerService customerService;

  public UserContextService(CustomerService customerService) {
    this.customerService = customerService;
  }

  protected Authentication authentication() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication == null) {
      throw new UserNotLoggedInException("No user is currently logged in");
    }
    return authentication;
  }

  public String getCurrentUserEmail() {
    return authentication().getName();
  }

  public boolean isManager() {
    return authentication().getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_MANAGER"));
  }

  public Customer getCurrentCustomer() {
    return customerService.getCustomer(authentication().getName());
  }
}
