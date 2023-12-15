package com.green.supermarketwebapp.feedback;

import java.sql.Date;

import com.green.supermarketwebapp.customer.Customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Feedback {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feedback_seq")
  @SequenceGenerator(name = "feedback_seq", sequenceName = "feedback_seq", allocationSize = 1, initialValue = 1000000000)
  private Long id;

  @ManyToOne
  private Customer customer;

  private String feedback;
  private Date date;

  @PrePersist
  protected void onCreate() {
    date = new Date(System.currentTimeMillis());
  }

  // Setters
  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public void setFeedback(String feedback) {
    this.feedback = feedback;
  }

  // Getters
  public Long getId() {
    return id;
  }

  public Customer getCustomer() {
    return customer;
  }

  public String getFeedback() {
    return feedback;
  }

  public Date getDate() {
    return date;
  }
}
