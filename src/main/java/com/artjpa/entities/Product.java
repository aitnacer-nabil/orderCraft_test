package com.artjpa.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "products", uniqueConstraints = @UniqueConstraint(
        name = "name_unique",
        columnNames = "name"
))
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private BigDecimal price;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "product",fetch = FetchType.EAGER)
    private Inventory inventory;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "product",fetch = FetchType.LAZY)
    private List<OrderItem> orderItemSet =  new ArrayList<>();
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", Inventory ='" + inventory + '\'' +
                '}';
    }

}
