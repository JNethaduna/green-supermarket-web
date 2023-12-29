package com.green.supermarketwebapp.tasks;

import java.sql.Timestamp;

import org.springframework.scheduling.annotation.Scheduled;

import com.green.supermarketwebapp.daos.StockLockDAO;

public class StockLockCleanupTask {
  private final StockLockDAO stockLockDAO;

  public StockLockCleanupTask(StockLockDAO stockLockDAO) {
    this.stockLockDAO = stockLockDAO;
  }

  @Scheduled(fixedRate = 60000) // 1 minute
  public void cleanupStockLocks() {
    Timestamp expirationTime = new Timestamp(System.currentTimeMillis() - 10 * 60 * 1000); // 10 minutes
    stockLockDAO.deleteByLockedTimeBefore(expirationTime);
  }
}
