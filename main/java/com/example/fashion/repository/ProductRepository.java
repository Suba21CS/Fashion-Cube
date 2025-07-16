package com.example.fashion.repository;

import com.example.fashion.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Basic CRUD already available from JpaRepository
}
