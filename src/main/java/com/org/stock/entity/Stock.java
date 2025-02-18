package com.org.stock.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "stock")
public class Stock {
    @Id
    @Column(name = "product_id")
    private String productId;

    @Column(name = "quantity")
    private int quantity;
}
