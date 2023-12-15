package com.green.supermarketwebapp.product;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/product/{id}")
  public String getProduct(Model model, @PathVariable Long id) {
    Product product = productService.getProduct(id);
    model.addAttribute("product", product);
    return "product";
  }

  @GetMapping("/products/list")
  public String getProducts(Model model,
      @RequestParam(defaultValue = "") String category,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "50") int size) {

    model.addAttribute("products", productService.getProducts(category, page, size));
    return "products";
  }
}
