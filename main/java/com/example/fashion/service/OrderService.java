package com.example.fashion.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fashion.model.Order;
import com.example.fashion.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order placeOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getOrdersByUser(String userName) {
        return orderRepository.findByUserName(userName);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
