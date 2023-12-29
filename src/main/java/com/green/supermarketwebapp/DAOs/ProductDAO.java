package com.green.supermarketwebapp.daos;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.green.supermarketwebapp.models.Product;

public interface ProductDAO extends JpaRepository<Product, Long> {
  Page<Product> findByCategory(String category, Pageable pageable);

  @Query("SELECT p.stock FROM Product p WHERE p.id = :id")
  Optional<Integer> findStockById(@Param("id") Long id);
}
