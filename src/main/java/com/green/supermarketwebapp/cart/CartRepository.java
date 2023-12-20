package com.green.supermarketwebapp.cart;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, CartId> {
  Page<Cart> findByCustomer_Id(Long customerId, Pageable pageable);

  List<Cart> findByCustomer_IdAndSelected(Long customerId, boolean selected);
}
