package com.examly.springapp.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long purchaseOrderId;
    private String orderNumber;
    private String status;
    private LocalDateTime orderDate;
    
    @ManyToOne
    @JoinColumn(name="supplier_id")
    private Supplier supplier;

    
    public long getPurchaseOrderId() {
        return purchaseOrderId;
    }
    public void setPurchaseOrderId(long purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }
    public String getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
    public Supplier getSupplier() {
        return supplier;
    }
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    public PurchaseOrder(){}
    
    public PurchaseOrder(String orderNumber, String status, LocalDateTime orderDate, Supplier supplier) {
        this.orderNumber = orderNumber;
        this.status = status;
        this.orderDate = orderDate;
        this.supplier = supplier;
    }
    public LocalDateTime getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
   
    
    
}
