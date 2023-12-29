package com.green.supermarketwebapp.daos;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.supermarketwebapp.models.StockLock;
import com.green.supermarketwebapp.models.keys.StockLockId;

public interface StockLockDAO extends JpaRepository<StockLock, StockLockId> {
  void deleteByLockedTimeBefore(Timestamp lockedTime);

  List<StockLock> findByProductId(Long productId);

  void deleteByCustomerId(Long customerId);
}
