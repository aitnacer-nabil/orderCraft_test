package com.artjpa.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private BigDecimal price;
    private int quantity;
    @OneToOne
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    private Product product;

}
