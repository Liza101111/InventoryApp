package com.springboot.inventoryapp.repository;

import com.springboot.inventoryapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
