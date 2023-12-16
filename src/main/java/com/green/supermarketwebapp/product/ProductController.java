package com.green.supermarketwebapp.product;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

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

  @GetMapping("/product/list")
  public String getProductList(Model model,
      @RequestParam(defaultValue = "") String category,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "50") int size) {

    model.addAttribute("products", productService.getProducts(category, page, size));
    return "product-list";
  }

  @PostMapping("/product/add")
  public String addProduct(@ModelAttribute Product product) {
    Long newProductId = productService.createProduct(product);
    return "redirect:/product/" + newProductId;
  }

  @PostMapping("/product/update/{id}")
  public String updateProduct(@PathVariable Long id, @ModelAttribute Product product) {
    product.setId(id);
    productService.updateProduct(product);
    return "redirect:/product/" + id;
  }

  @PostMapping("/product/delete/{id}")
  public void deleteProduct(@PathVariable Long id) {
    productService.deleteProduct(id);
  }
}
