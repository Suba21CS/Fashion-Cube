package com.example.fashion.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private double totalPrice;
    private String paymentMethod; // COD / GOOGLE_PAY / PHONE_PE
    private String status; // PENDING, PAID, FAILED, DELIVERED
    private LocalDateTime orderDate;

    private String deliveryAddress;
    private String upiId;
    private String pincode;

    public Order() {}

    public Order(String userName, double totalPrice, String paymentMethod, String status,
                 String deliveryAddress, String upiId, String pincode) {
        this.userName = userName;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.deliveryAddress = deliveryAddress;
        this.upiId = upiId;
        this.pincode = pincode;
        this.orderDate = LocalDateTime.now();
    }

    @PrePersist
    protected void onCreate() {
        this.orderDate = LocalDateTime.now();
    }

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getUpiId() {
        return upiId;
    }

    public void setUpiId(String upiId) {
        this.upiId = upiId;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
