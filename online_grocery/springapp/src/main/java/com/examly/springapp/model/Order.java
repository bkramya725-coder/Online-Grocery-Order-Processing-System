package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long orderId;
    private long customerId;
    private String status;
    private String orderDate;
    private double totalAmount;
    private String paymentStatus;
    public long getOrderId() {
        return orderId;
    }
    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }
    public long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
    public double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    public String getPaymentStatus() {
        return paymentStatus;
    }
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    
    public Order(){}

    public Order(long customerId, String status, String orderDate, double totalAmount,
            String paymentStatus) {
       
        this.customerId = customerId;
        this.status = status;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
    }
    
}
