package com.springboot.inventoryapp.repository;

import com.springboot.inventoryapp.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
}
