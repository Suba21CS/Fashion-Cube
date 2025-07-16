package com.example.fashion.repository;

import com.example.fashion.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByUserName(String userName);
    void deleteByUserName(String userName);
}
