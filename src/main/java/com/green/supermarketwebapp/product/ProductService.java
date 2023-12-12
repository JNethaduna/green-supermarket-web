package com.green.supermarketwebapp.product;

import java.util.NoSuchElementException;

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

  public void createProduct(Product product) {
    productRepository.save(product);
  }

  // TODO: Implement updateProduct
  public void updateProduct(Product product) {
    productRepository.save(product);
  }

  public void deleteProduct(Long id) {
    productRepository.deleteById(id);
  }
}
