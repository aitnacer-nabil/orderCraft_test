package com.artjpa.service.impl;

import com.artjpa.AppConfig.ApplicationConfig;
import com.artjpa.entities.Inventory;
import com.artjpa.entities.Product;
import javax.transaction.Transactional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationConfig.class)
class InventoryServiceImplTest {
    @Autowired
    InventoryServiceImpl inventoryService;
    @Autowired
    ProductServiceImpl productService;
    static Product product = new Product();

    @BeforeAll
    static void setup(){
        product.setPrice(new BigDecimal(250));
        product.setDescription("description");
        product.setName("name");
    }
    @BeforeEach
    void before(){
        System.out.println("Before Each Method test");
    }
    @Test
    @Transactional
    @DisplayName("Test Save Inventory")
    void saveInventory() {
        Inventory inventory = new Inventory();
        inventory.setQuantityInStock(14);
        product.setInventory(inventory);
        inventory.setProduct(product);
        assertNotNull(product);
        Inventory inventorySaved = inventoryService.saveInventory(inventory);
        assertNotNull(inventorySaved);
        System.out.println(inventory);
    }

    @Test
    @Transactional
    void getInventoryById() {

        Inventory inventory = inventoryService.getInventoryById(4l);
        System.out.println(inventory);
        assertNotNull(inventory);
        System.out.println(inventory.getProduct());
    }

    @Test
    void getAllInventories() {
        List<Inventory> inventories = inventoryService.getAllInventories();
        assertTrue(inventories.size() > 0);
        System.out.println(inventories);

    }

    @Test
    void deleteInventory() {
        inventoryService.deleteInventory(3l);
    }
}