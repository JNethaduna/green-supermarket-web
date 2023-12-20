package com.green.supermarketwebapp.feedback;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.green.supermarketwebapp.auth.UserContextService;

@Service
public class FeedbackService {
  private final FeedbackRepository feedbackRepository;
  private final UserContextService userContextService;

  public FeedbackService(FeedbackRepository feedbackRepository, UserContextService userContextService) {
    this.feedbackRepository = feedbackRepository;
    this.userContextService = userContextService;
  }

  public Feedback saveFeedback(Feedback feedback) {
    feedback.setCustomer(userContextService.getCurrentCustomer());
    return feedbackRepository.save(feedback);
  }

  public List<Feedback> getFeedbacks(int page, int size) {
    return feedbackRepository.findAll(PageRequest.of(page, size)).getContent();
  }
}