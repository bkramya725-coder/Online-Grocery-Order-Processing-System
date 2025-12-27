package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
@Entity
public class Inventory {
    @Id
    private long inventorId;
    @OneToOne
    @JoinColumn(name="product_id")
    private Product product;
    private int quantity;
    public long getInventorId() {
        return inventorId;
    }
    public void setInventorId(long inventorId) {
        this.inventorId = inventorId;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public Inventory(){}
    public Inventory(long inventorId,Product product, int quantity) {
        this.inventorId = inventorId;
        this.product = product;
        this.quantity = quantity;
    }

    
}
