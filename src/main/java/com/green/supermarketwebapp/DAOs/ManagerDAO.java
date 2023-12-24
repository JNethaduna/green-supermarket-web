package com.green.supermarketwebapp.daos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.supermarketwebapp.models.Manager;

public interface ManagerDAO extends JpaRepository<Manager, Long> {
  Optional<Manager> findByEmail(String email);
}
