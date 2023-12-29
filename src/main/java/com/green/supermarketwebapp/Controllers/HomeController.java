package com.green.supermarketwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;

import com.green.supermarketwebapp.models.Manager;
import com.green.supermarketwebapp.services.ManagerService;
import com.green.supermarketwebapp.services.ProductService;

@Controller
public class HomeController {
  private final ManagerService managerService;
  private final ProductService productService;

  public HomeController(ManagerService managerService, ProductService productService) {
    this.managerService = managerService;
    this.productService = productService;
  }

  @GetMapping("/")
  public String home(Model model) {
    model.addAttribute("products", productService.getPopularProducts());
    return "index";
  }

  @GetMapping("/login")
  public String login(HttpServletRequest request) {
    HttpSession session = request.getSession();
    String referrer = request.getHeader("Referer");
    if (referrer != null && !referrer.contains("/login") && !referrer.contains("/register")) {
      session.setAttribute("url_prior_login", referrer);
    }
    return "login";
  }

  @GetMapping("/register")
  public String register(HttpServletRequest request) {
    HttpSession session = request.getSession();
    String referrer = request.getHeader("Referer");
    if (referrer != null && !referrer.contains("/login") && !referrer.contains("/register")) {
      session.setAttribute("url_prior_login", referrer);
    }
    return "register";
  }

  @GetMapping("/manage/manager")
  public String newManager() {
    return "manager-add";
  }

  @PostMapping("/manage/create/manager")
  public String addManager(@ModelAttribute Manager manager) {
    managerService.createManager(manager);
    return "/";
  }

}
