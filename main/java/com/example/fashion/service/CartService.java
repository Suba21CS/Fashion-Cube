package com.example.fashion.service;

import com.example.fashion.model.CartItem;
import com.example.fashion.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartItemRepository cartItemRepository;

    public CartItem addToCart(CartItem item) {
        return cartItemRepository.save(item);
    }

    public List<CartItem> getCartByUserName(String userName) {
        return cartItemRepository.findByUserName(userName);
    }

    public void clearCartByUserName(String userName) {
        cartItemRepository.deleteByUserName(userName);
    }

    public void removeCartItem(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }


}
