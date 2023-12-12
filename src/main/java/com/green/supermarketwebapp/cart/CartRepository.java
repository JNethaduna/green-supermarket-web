package com.green.supermarketwebapp.cart;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, CartId> {
  Page<Cart> findByCustomerId(Long customerId, Pageable pageable);
}
