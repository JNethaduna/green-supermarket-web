package com.green.supermarketwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.supermarketwebapp.services.FeedbackService;

@Controller
public class FeedbackController {
  private final FeedbackService feedbackService;

  public FeedbackController(FeedbackService feedbackService) {
    this.feedbackService = feedbackService;
  }

  @GetMapping("/user/feedback")
  public String getFeedback() {
    return "feedback";
  }

  @GetMapping("/manage/feedback/list")
  public String getFeedbackList(Model model, @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "20") int size) {
    model.addAttribute("feedbacks", feedbackService.getFeedbacks(page, size));
    return "feedback-list";
  }

  @PostMapping("/user/feedback/submit")
  public String submitFeedback(@RequestParam("feedback") String feedback) {
    feedbackService.saveFeedback(feedback);
    return "redirect:/feedback-success";
  }

  @GetMapping("/feedback-success")
  public String getFeedbackSuccess() {
    return "feedback-success";
  }
}