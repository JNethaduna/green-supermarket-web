package com.green.supermarketwebapp.daos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.green.supermarketwebapp.models.Cart;
import com.green.supermarketwebapp.models.keys.CartId;

public interface CartDAO extends JpaRepository<Cart, CartId> {
  Page<Cart> findByCustomer_Id(Long customerId, Pageable pageable);

  List<Cart> findByCustomer_IdAndSelected(Long customerId, boolean selected);
}
