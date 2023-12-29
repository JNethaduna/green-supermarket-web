package com.green.supermarketwebapp.controllers;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.green.supermarketwebapp.exceptions.EmailTakenException;
import com.green.supermarketwebapp.models.Customer;
import com.green.supermarketwebapp.services.CustomerService;
import com.green.supermarketwebapp.services.OrderService;
import com.green.supermarketwebapp.services.UserContextService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CustomerController {
  private final CustomerService customerService;
  private final AuthenticationManager authenticationManager;
  private final UserContextService userContextService;
  private final OrderService orderService;

  public CustomerController(CustomerService customerService,
      AuthenticationManager authenticationManager,
      UserContextService userContextService,
      OrderService orderService) {
    this.customerService = customerService;
    this.authenticationManager = authenticationManager;
    this.userContextService = userContextService;
    this.orderService = orderService;
  }

  @PostMapping("/register")
  public String registerCustomer(@ModelAttribute Customer customer, HttpServletRequest request) {
    try {
      if (customerService.existingCustomer(customer.getEmail())) {
        throw new EmailTakenException("Email already exists");
      }
      customerService.createCustomer(customer);
      UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
          customer.getEmail(), customer.getPassword());
      Authentication authentication = authenticationManager.authenticate(token);
      SecurityContextHolder.getContext().setAuthentication(authentication);

      return "redirect:/" + request.getSession().getAttribute("url_prior_login");

    } catch (IllegalArgumentException e) {
      return "redirect:/register?error";

    } catch (EmailTakenException e) {
      return "redirect:/register?emailTaken";
    } catch (AuthenticationException e) {
      return "redirect:/login";
    }
  }

  @GetMapping("/user/profile")
  public String getProfile(Model model) {
    model.addAttribute("customer", userContextService.getCurrentCustomer());
    model.addAttribute("orders", orderService.getOrders(null, 0, 50));
    return "user-profile";
  }

  @PostMapping("/user/profile/update")
  public String updateProfile(@ModelAttribute Customer customer) {
    customerService.updateCustomer(customer);
    return "redirect:/user/profile";
  }
}
