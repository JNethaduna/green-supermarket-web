package com.green.supermarketwebapp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Manager {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "manager_seq")
  @SequenceGenerator(name = "manager_seq", sequenceName = "manager_seq", allocationSize = 1, initialValue = 100)
  private Long id;

  @Column(unique = true)
  private String email;

  private String password;

  // Setters
  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  // Getters
  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }
}
