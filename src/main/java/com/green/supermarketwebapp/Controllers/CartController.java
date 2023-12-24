package com.green.supermarketwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.supermarketwebapp.services.CartService;

@Controller
public class CartController {
  private final CartService cartService;

  public CartController(CartService cartService) {
    this.cartService = cartService;
  }

  @GetMapping("/user/cart")
  public String getCart(Model model) {
    model.addAttribute("cart", cartService.getCustomerCart(0, 50));
    return "cart";
  }

  @PostMapping("/user/cart/add")
  public void addToCart(@RequestParam("id") Long productId, @RequestParam int quantity) {
    cartService.addToCart(productId, quantity);
  }

  @PostMapping("/user/cart/remove")
  public void removeFromCart(@RequestParam("id") Long productId) {
    cartService.removeFromCart(productId);
  }
}
