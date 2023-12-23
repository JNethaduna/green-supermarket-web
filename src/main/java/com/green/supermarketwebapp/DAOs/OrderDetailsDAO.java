package com.green.supermarketwebapp.DAOs;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.supermarketwebapp.Models.OrderDetails;
import com.green.supermarketwebapp.Models.Keys.OrderDetailsId;

public interface OrderDetailsDAO extends JpaRepository<OrderDetails, OrderDetailsId> {

}
