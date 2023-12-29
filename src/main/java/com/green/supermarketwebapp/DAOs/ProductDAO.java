package com.green.supermarketwebapp.daos;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.green.supermarketwebapp.models.Product;

public interface ProductDAO extends JpaRepository<Product, Long> {
  Page<Product> findByCategory(String category, Pageable pageable);

  Optional<Integer> findStockById(Long id);
}
