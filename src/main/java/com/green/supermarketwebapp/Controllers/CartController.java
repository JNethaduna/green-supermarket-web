package com.green.supermarketwebapp.controllers;

import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<String> addToCart(@RequestParam("id") Long productId, @RequestParam int quantity) {
    try {
      cartService.addToCart(productId, quantity);
      return ResponseEntity.ok("Product added to cart successfully");
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }

  }

  @PostMapping("/user/cart/remove")
  public ResponseEntity<String> removeFromCart(@RequestParam("id") Long productId) {
    try {
      cartService.removeFromCart(productId);
      return ResponseEntity.ok("Product removed from cart successfully");
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
