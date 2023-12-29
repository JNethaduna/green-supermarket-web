package com.green.supermarketwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.supermarketwebapp.models.Product;
import com.green.supermarketwebapp.services.ProductService;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  // Access to all
  @GetMapping("/product/{id}")
  public String getProduct(Model model, @PathVariable Long id) {
    Product product = productService.getProduct(id);
    model.addAttribute("product", product);
    return "product";
  }

  @GetMapping("/product/list")
  public String getProductList(Model model,
      @RequestParam(defaultValue = "") String category,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "50") int size) {

    model.addAttribute("products", productService.getProducts(category, page, size));
    return "product-list";
  }

  // Manager access only
  @GetMapping("/manage/product/{id}")
  public String manageProduct(Model model, @PathVariable Long id) {
    model.addAttribute("product", productService.getProduct(id));
    model.addAttribute("manage", true);
    return "product";
  }

  @GetMapping("/manage/product/list")
  public String manageProductList(Model model,
      @RequestParam(defaultValue = "") String category,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "50") int size) {

    model.addAttribute("products", productService.getProducts(category, page, size));
    model.addAttribute("manage", true);
    return "product-list";
  }

  @GetMapping("/manage/product/add")
  public String addProduct() {
    return "product-add";
  }

  @PostMapping("/manage/product/add")
  public String addProduct(@ModelAttribute Product product) {
    try {
      Long newProductId = productService.saveProduct(product);
      return "redirect:/product/" + newProductId;
    } catch (IllegalArgumentException e) {
      return "redirect:/manage/product/add?error";
    }
  }

  @PostMapping("/manage/product/update/{id}")
  public String updateProduct(@PathVariable Long id, @ModelAttribute Product product) {
    product.setId(id);
    try {
      productService.saveProduct(product);
      return "redirect:/product/" + id;
    } catch (IllegalArgumentException e) {
      return "redirect:/manage/product/update/" + id + "?error";
    }
  }

  @PostMapping("/manage/product/delete/{id}")
  public void deleteProduct(@PathVariable Long id) {
    productService.deleteProduct(id);
  }
}
