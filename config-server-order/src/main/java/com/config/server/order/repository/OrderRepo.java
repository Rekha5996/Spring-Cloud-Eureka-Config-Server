package com.config.server.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.config.server.order.model.Order;

public interface OrderRepo extends JpaRepository<Order, Long>{

}
