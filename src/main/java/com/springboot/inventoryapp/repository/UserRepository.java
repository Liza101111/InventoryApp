package com.springboot.inventoryapp.repository;

import com.springboot.inventoryapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
