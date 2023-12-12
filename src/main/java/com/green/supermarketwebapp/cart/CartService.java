package com.green.supermarketwebapp.cart;

import org.springframework.stereotype.Service;

import com.green.supermarketwebapp.customer.Customer;
import com.green.supermarketwebapp.product.Product;

@Service
public class CartService {
  private final CartRepository cartRepository;

  public CartService(CartRepository cartRepository) {
    this.cartRepository = cartRepository;
  }

  public void addToCart(Customer customer, Product product, int quantity) {
    Cart cart = new Cart();
    cart.setCustomer(customer);
    cart.setProduct(product);
    cart.setQuantity(quantity);
    cartRepository.save(cart);
  }

  public void removeFromCart(Customer customer, Product product) {
    CartId cartId = new CartId(customer.getId(), product.getId());
    cartRepository.deleteById(cartId);
  }
}
