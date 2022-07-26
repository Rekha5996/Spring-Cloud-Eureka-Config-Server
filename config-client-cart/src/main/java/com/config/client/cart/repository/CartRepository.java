package com.config.client.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.config.client.cart.model.Cart;


public interface CartRepository extends JpaRepository<Cart, Long>{

}
