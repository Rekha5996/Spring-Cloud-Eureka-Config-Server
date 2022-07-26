package com.config.client.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.config.client.cart.model.CartItems;

public interface CartItemsRepository extends JpaRepository<CartItems, Long>{

}
