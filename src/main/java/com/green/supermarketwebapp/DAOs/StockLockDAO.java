package com.green.supermarketwebapp.daos;

import java.security.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.supermarketwebapp.models.StockLock;
import com.green.supermarketwebapp.models.keys.StockLockId;

public interface StockLockDAO extends JpaRepository<StockLock, StockLockId> {
  void deleteByLockedTimeBefore(Timestamp lockedTime);
}
