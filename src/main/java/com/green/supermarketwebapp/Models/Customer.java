package com.green.supermarketwebapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
  @SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq", allocationSize = 1, initialValue = 1000000000)
  private Long id;

  private String fName;
  private String lName;
  private String email;
  private String password;
  private String address;
  private String phone;

  // Setters
  public void setFName(String fName) {
    this.fName = fName;
  }

  public void setLName(String lName) {
    this.lName = lName;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  // Getters
  public Long getId() {
    return id;
  }

  public String getFirstName() {
    return fName;
  }

  public String getLastName() {
    return lName;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public String getAddress() {
    return address;
  }

  public String getPhone() {
    return phone;
  }
}
