package com.green.supermarketwebapp.DAOs;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.supermarketwebapp.Models.Manager;

public interface ManagerDAO extends JpaRepository<Manager, Long> {
  Optional<Manager> findByEmail(String email);
}
