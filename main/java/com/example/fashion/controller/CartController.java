package com.example.fashion.controller;

import com.example.fashion.model.CartItem;
import com.example.fashion.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@CrossOrigin("*")
public class CartController {

    @Autowired
    private CartService cartService;

    // Add item to cart
    @PostMapping("/add")
    public CartItem addToCart(@RequestBody CartItem item) {
        return cartService.addToCart(item);
    }

    // Get all cart items for a specific user (by userName)
    @GetMapping("/user/{userName}")
    public List<CartItem> getCartItemsByUser(@PathVariable String userName) {
        return cartService.getCartByUserName(userName);
    }

    // Delete a specific cart item by cart item ID
    @DeleteMapping("/{cartItemId}")
    public void deleteCartItem(@PathVariable Long cartItemId) {
        cartService.removeCartItem(cartItemId);
    }

    // Clear all cart items for a user (by userName)
    @DeleteMapping("/clear/{userName}")
    public void clearCartByUser(@PathVariable String userName) {
        cartService.clearCartByUserName(userName);
    }
}
