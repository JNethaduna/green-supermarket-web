package com.green.supermarketwebapp.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.green.supermarketwebapp.daos.ManagerDAO;
import com.green.supermarketwebapp.models.Manager;

@Service
public class ManagerService {
  private final ManagerDAO managerDao;
  private final PasswordEncoder passwordEncoder;

  public ManagerService(ManagerDAO managerDao, PasswordEncoder passwordEncoder) {
    this.managerDao = managerDao;
    this.passwordEncoder = passwordEncoder;
  }

  public boolean existingManager(String email) {
    return managerDao.findByEmail(email).isPresent();
  }

  public void createManager(Manager manager) {
    manager.setPassword(passwordEncoder.encode(manager.getPassword()));
    managerDao.save(manager);
  }
}
