package com.springboot.inventoryapp.repository;

import com.springboot.inventoryapp.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
}
