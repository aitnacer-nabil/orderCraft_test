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
@Table(name = "inventories")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Setter
    @Column(name = "quantity_in_stock")
    private int quantityInStock;

    @Column(name = "quantity_sales")
    private int quantitySales;
    @Setter
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id",referencedColumnName = "id",nullable = false)
    private Product product;


    public void setQuantitySales(int quantitySales) {
        if(this.quantityInStock - quantitySales >= 0){
            this.quantitySales += quantitySales;
            this.quantityInStock -= quantitySales;
        }


    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", quantityInStock=" + quantityInStock +
                ", quantitySales=" + quantitySales +
                '}';
    }
    private boolean checkQte(int qte){
        return (this.quantityInStock -qte >= 0);
    }
}
