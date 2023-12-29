package com.green.supermarketwebapp.services;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.green.supermarketwebapp.daos.ProductDAO;
import com.green.supermarketwebapp.exceptions.CategoryNotFoundException;
import com.green.supermarketwebapp.exceptions.ProductNotFoundException;
import com.green.supermarketwebapp.models.Product;

@Service
public class ProductService {
  private final ProductDAO productRepository;
  private final StockLockService stockLockService;

  public ProductService(ProductDAO productRepository, StockLockService stockLockService) {
    this.productRepository = productRepository;
    this.stockLockService = stockLockService;
  }

  public Product getProduct(Long id) {
    return productRepository.findById(id)
        .orElseThrow(() -> new ProductNotFoundException("Product with the Id does not exist"));
  }

  public List<Product> getProducts(String category, int page, int size) {
    if (category == null || category.isEmpty()) {
      return productRepository.findAll(PageRequest.of(page, size)).getContent();
    } else {
      System.out.println("Category: " + category);
      System.out.println("Formatted Category: " + Helpers.formatCategory(category));
      List<Product> products = productRepository
          .findByCategory(Helpers.formatCategory(category), PageRequest.of(page, size))
          .getContent();

      if (products.isEmpty()) {
        throw new CategoryNotFoundException("No products found for the category");
      }
      return products;
    }

  }

  public Integer getStock(Long id) {
    return productRepository.findStockById(id)
        .orElseThrow(() -> new ProductNotFoundException("Product with the Id does not exist"));
  }

  public Integer checkAvailableStock(Long id) {
    Integer stock = getStock(id);
    Integer lockedStock = stockLockService.getLockedProductStock(id);
    return stock - lockedStock;
  }

  public Long saveProduct(Product product) {
    return productRepository.save(product).getId();
  }

  public void deleteProduct(Long id) {
    productRepository.deleteById(id);
  }

  public void decreaseStock(Long productId, int quantity) {
    Product product = getProduct(productId);
    product.setStock(product.getStock() - quantity);
    productRepository.save(product);
  }

  public List<Product> getPopularProducts() {
    List<Product> allProducts = productRepository.findAll();
    Collections.shuffle(allProducts);
    return allProducts.stream().limit(30).collect(Collectors.toList());
  }
}
