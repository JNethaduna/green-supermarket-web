package com.green.supermarketwebapp.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
  private final CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @PostMapping("/register")
  public String registerCustomer(@ModelAttribute Customer customer) {
    System.out.println("Hey");
    System.out.println(customerService.createCustomer(customer));
    return "redirect:/login";
  }
}
