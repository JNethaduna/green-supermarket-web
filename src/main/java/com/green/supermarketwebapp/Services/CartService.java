package com.green.supermarketwebapp.services;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.green.supermarketwebapp.daos.CartDAO;
import com.green.supermarketwebapp.models.Cart;
import com.green.supermarketwebapp.models.Customer;
import com.green.supermarketwebapp.models.Product;
import com.green.supermarketwebapp.models.keys.CartId;

@Service
public class CartService {
  private final CartDAO cartRepository;
  private final ProductService productService;
  private final UserContextService userContextService;

  public CartService(CartDAO cartRepository, UserContextService userContextService,
      ProductService productService) {
    this.cartRepository = cartRepository;
    this.userContextService = userContextService;
    this.productService = productService;
  }

  public List<Cart> getCustomerCart(int page, int size) {
    Customer customer = userContextService.getCurrentCustomer();
    return cartRepository.findByCustomer_Id(customer.getId(), PageRequest.of(page, size)).getContent();
  }

  public void addToCart(Long productId, int quantity) {
    Customer customer = userContextService.getCurrentCustomer();
    Product product = productService.getProduct(productId); // throws ProductNotFoundException
    Cart cart = new Cart(customer, product, quantity);
    cartRepository.save(cart);
  }

  public void removeFromCart(Long productId) {
    Customer customer = userContextService.getCurrentCustomer();
    Product product = productService.getProduct(productId); // throws ProductNotFoundException
    CartId cartId = new CartId(customer.getId(), product.getId());
    cartRepository.deleteById(cartId);
  }

  public void removeAllFromCart(List<Cart> cartItems) {
    cartRepository.deleteAll(cartItems);
  }

  public List<Cart> getSelected(Customer customer) {
    return cartRepository.findByCustomer_IdAndSelected(customer.getId(), true);
  }

  public double getTotal() {
    Customer customer = userContextService.getCurrentCustomer();
    List<Cart> selected = getSelected(customer);
    double total = 0;
    for (Cart item : selected) {
      total += item.getProduct().getPrice() * item.getQuantity();
    }
    return total;
  }
}
