package com.artjpa.entities;

import javax.persistence.*;
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
    private BigDecimal amount= new BigDecimal(0);
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

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", price=" + amount +
                ", quantity=" + quantity +
                '}';
    }
}
