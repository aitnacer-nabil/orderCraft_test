package com.artjpa.entities.mock;

import com.artjpa.entities.Inventory;
import com.artjpa.entities.Product;

import java.math.BigDecimal;

public class ProductMock {

    public static Product mockRequest(){
        Product product = new Product();

        String name = "testProduct";
        product.getName();
        String description = "testDescription";
        product.getDescription();
        BigDecimal price = new BigDecimal("750.50");
        product.getPrice();

        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);

        Inventory inventory = new Inventory();
        inventory.setQuantityInStock(60);
        product.setInventory(inventory);
        inventory.setProduct(product);

        return product;
    }
}
