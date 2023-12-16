package com.green.supermarketwebapp.product;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Product getProduct(Long id) {
    return productRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Product not found"));
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
