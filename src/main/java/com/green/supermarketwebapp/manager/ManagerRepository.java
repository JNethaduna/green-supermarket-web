package com.green.supermarketwebapp.manager;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
  Optional<Manager> findByEmail(String email);
}
