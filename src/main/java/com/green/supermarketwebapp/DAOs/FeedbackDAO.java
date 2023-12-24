package com.green.supermarketwebapp.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.supermarketwebapp.models.Feedback;

public interface FeedbackDAO extends JpaRepository<Feedback, Long> {

}
