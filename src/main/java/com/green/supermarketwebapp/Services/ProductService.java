package com.green.supermarketwebapp.Services;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.green.supermarketwebapp.DAOs.ProductDAO;
import com.green.supermarketwebapp.Exceptions.ProductNotFoundException;
import com.green.supermarketwebapp.Models.Product;

@Service
public class ProductService {
  private final ProductDAO productRepository;

  public ProductService(ProductDAO productRepository) {
    this.productRepository = productRepository;
  }

  public Product getProduct(Long id) {
    return productRepository.findById(id)
        .orElseThrow(() -> new ProductNotFoundException("Product with the Id does not exist"));
  }

  public List<Product> getProducts(String category, int page, int size) {
    if (category == null || category.isEmpty()) {
      return productRepository.findAll(PageRequest.of(page, size)).getContent();
    } else {
      return productRepository.findByCategory(category, PageRequest.of(page, size)).getContent();
    }
  }

  public Long createProduct(Product product) {
    return productRepository.save(product).getId();
  }

  public void updateProduct(Product product) {
    productRepository.save(product);
  }

  public void deleteProduct(Long id) {
    productRepository.deleteById(id);
  }
}
