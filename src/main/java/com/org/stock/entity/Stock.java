package com.org.stock.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class Stock {

    @Id
    @Column(name = "product_id")
    private String productId;

    @Column(name = "quantity")
    private int quantity;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
