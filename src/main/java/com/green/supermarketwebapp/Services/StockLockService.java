package com.green.supermarketwebapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.green.supermarketwebapp.daos.StockLockDAO;
import com.green.supermarketwebapp.models.Customer;
import com.green.supermarketwebapp.models.Product;
import com.green.supermarketwebapp.models.StockLock;

@Service
public class StockLockService {
  private final StockLockDAO stockLockDAO;

  public StockLockService(StockLockDAO stockLockDAO) {
    this.stockLockDAO = stockLockDAO;
  }

  public void createStockLock(Customer customer, Product product, int quantity) {
    StockLock stockLock = new StockLock(customer, product, quantity);
    stockLockDAO.save(stockLock);
  }

  public Integer getLockedProductStock(Long productId) {
    List<StockLock> stockLocks = stockLockDAO.findByProductId(productId);
    return stockLocks.stream().mapToInt(StockLock::getQuantity).sum();
  }

  public void deleteStockLock(StockLock stockLock) {
    stockLockDAO.delete(stockLock);
  }

  public void deleteCustomerStockLocks(Customer customer) {
    stockLockDAO.deleteByCustomerId(customer.getId());
  }
}
