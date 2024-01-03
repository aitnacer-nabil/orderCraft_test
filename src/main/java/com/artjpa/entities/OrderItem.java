package com.artjpa.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "order_item")
public class OrderItem {
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Setter
    private BigDecimal amount= new BigDecimal(0);

    @Setter
    private int quantity;


    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @Setter
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;


    public void setQuantity(int quantity) {

        this.quantity = quantity;
        this.amount = this.product.getPrice().multiply(new BigDecimal(this.quantity));
    }

    public OrderItem(BigDecimal amount, int quantity, Product product) {
        this.amount = amount;
        this.quantity = quantity;
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", price=" + amount +
                ", quantity=" + quantity +
                '}';
    }
}
