package com.green.supermarketwebapp.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.green.supermarketwebapp.exceptions.CategoryNotFoundException;
import com.green.supermarketwebapp.exceptions.OrderNotFoundException;
import com.green.supermarketwebapp.exceptions.ProductNotFoundException;
import com.green.supermarketwebapp.exceptions.UserNotLoggedInException;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(ProductNotFoundException.class)
  public String handleProductNotFoundException(ProductNotFoundException e, Model model) {
    model.addAttribute("message", e.getMessage());
    return "error";
  }

  @ExceptionHandler(CategoryNotFoundException.class)
  public String handleCategoryNotFoundException(CategoryNotFoundException e, Model model) {
    model.addAttribute("message", e.getMessage());
    return "error";
  }

  @ExceptionHandler(UserNotLoggedInException.class)
  public String handleUserNotLoggedInException(UserNotLoggedInException e) {
    return "login";
  }

  @ExceptionHandler(OrderNotFoundException.class)
  public String handleOrderNotFoundException(OrderNotFoundException e, Model model) {
    model.addAttribute("message", e.getMessage());
    return "error";
  }
}
