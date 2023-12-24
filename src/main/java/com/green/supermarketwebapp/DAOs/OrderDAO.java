package com.green.supermarketwebapp.daos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.green.supermarketwebapp.models.Order;

public interface OrderDAO extends JpaRepository<Order, Long> {
  Page<Order> findByCustomer_IdAndStatus(Long customerId, String status, Pageable pageable);

  Page<Order> findByCustomer_Id(Long customerId, Pageable pageable);
}
