package com.artjpa.service.impl;

import com.artjpa.AppConfig.ApplicationConfig;
import com.artjpa.entities.Inventory;
import com.artjpa.entities.Product;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationConfig.class)
class InventoryServiceImplTest {
    @Autowired
    InventoryServiceImpl inventoryService;
    @Autowired
    ProductServiceImpl productService;

    @Test
    @Transactional
    void saveInventory() {
        Inventory inventory = new Inventory();
        inventory.setQuantityInStock(14);
        Product product = new Product();
        product.setPrice(new BigDecimal(250));
        product.setDescription("description");
        product.setName("name");
    ;
        product.setInventory(inventory);
        inventory.setProduct(product);
        assertNotNull(product);

        assertNotNull(inventoryService.saveInventory(inventory));
    }

    @Test
    @Transactional
    void getInventoryById() {

        Inventory inventory = inventoryService.getInventoryById(2l);
        assertNotNull(inventory);
        System.out.println(inventory.getProduct());
    }

    @Test
    void getAllInventories() {
    }

    @Test
    void deleteInventory() {
        inventoryService.deleteInventory(3l);
    }
}