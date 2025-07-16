package com.example.fashion.controller;

import com.example.fashion.model.Order;
import com.example.fashion.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin("*")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // ✅ Final working version for placing order
    @PostMapping("/place")
    public ResponseEntity<String> placeOrder(@RequestBody Order order) {
        order.setStatus("PENDING");
        orderService.placeOrder(order);  // Save via service
        return ResponseEntity.ok("Order placed");
    }

    // View user orders
    @GetMapping("/user/{userName}")
    public List<Order> getOrdersByUser(@PathVariable String userName) {
        return orderService.getOrdersByUser(userName);
    }
 

    // Admin: View all orders
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
}
