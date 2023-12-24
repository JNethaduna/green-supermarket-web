package com.green.supermarketwebapp.daos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.green.supermarketwebapp.models.Product;

public interface ProductDAO extends JpaRepository<Product, Long> {
  Page<Product> findByCategory(String category, Pageable pageable);
}
