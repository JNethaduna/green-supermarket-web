package com.green.supermarketwebapp.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.supermarketwebapp.models.OrderDetails;
import com.green.supermarketwebapp.models.keys.OrderDetailsId;

public interface OrderDetailsDAO extends JpaRepository<OrderDetails, OrderDetailsId> {

}
