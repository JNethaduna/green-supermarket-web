package com.green.supermarketwebapp.DAOs;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.green.supermarketwebapp.Models.Product;

public interface ProductDAO extends JpaRepository<Product, Long> {
  Page<Product> findByCategory(String category, Pageable pageable);
}
