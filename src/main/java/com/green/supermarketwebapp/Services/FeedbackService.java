package com.green.supermarketwebapp.services;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.green.supermarketwebapp.daos.FeedbackDAO;
import com.green.supermarketwebapp.models.Feedback;

@Service
public class FeedbackService {
  private final FeedbackDAO feedbackRepository;
  private final UserContextService userContextService;

  public FeedbackService(FeedbackDAO feedbackRepository, UserContextService userContextService) {
    this.feedbackRepository = feedbackRepository;
    this.userContextService = userContextService;
  }

  public Feedback saveFeedback(String body) {
    Feedback feedback = new Feedback();
    feedback.setCustomer(userContextService.getCurrentCustomer());
    feedback.setFeedback(body);
    return feedbackRepository.save(feedback);
  }

  public List<Feedback> getFeedbacks(int page, int size) {
    return feedbackRepository.findAll(PageRequest.of(page, size)).getContent();
  }
}