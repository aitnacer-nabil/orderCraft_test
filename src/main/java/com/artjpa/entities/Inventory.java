package com.artjpa.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
@Data
@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "quantity_in_stock")
    private int quantityInStock;
    @Column(name = "quantity_sales")
    private int quantitySales;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id",referencedColumnName = "id")
    private Product product;

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", quantityInStock=" + quantityInStock +
                ", quantitySales=" + quantitySales +
                '}';
    }
}
