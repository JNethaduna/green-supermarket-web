package com.green.supermarketwebapp.DAOs;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.supermarketwebapp.Models.Feedback;

public interface FeedbackDAO extends JpaRepository<Feedback, Long> {

}
