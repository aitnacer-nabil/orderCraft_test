package com.artjpa.service.impl;

import com.artjpa.AppConfig.ApplicationConfig;
import com.artjpa.entities.Inventory;
import com.artjpa.entities.Product;
import javax.transaction.Transactional;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;



@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationConfig.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private InventoryServiceImpl inventoryService;

    static List<Product> products;
    static Product product ;

    @BeforeAll
    static void setUp() {
        System.out.println("Before ALL Testing ProductService and inventoryService");
        products = new ArrayList<>();
    }
    @ParameterizedTest
    @Order(1)
    @DisplayName("Get Products from csv file")
    @CsvFileSource(resources = "/product.csv",  delimiter = ',')
    void getlistProductFromCsv(String name, String description, String price, int qteStock) {
        Inventory inventory = new Inventory();
        inventory.setQuantityInStock(qteStock);
        Product product = new Product();
        product.setPrice(new BigDecimal(price));
        product.setDescription(description);
        product.setName(name);
        product.setInventory(inventory);
        inventory.setProduct(product);
        products.add(product);
        System.out.println(products.size());

    }
    @Test
    @DisplayName("Insert Products List to database")
    @Order(2)
    @Transactional
    @Rollback(value = false)
    void saveProduct() {

        products.forEach(product1 -> {
            assertNotNull(productService.saveProduct(product1));

        });


    }
    @Test
    @DisplayName("Get Product And inventory ")
    @Order(3)
    void getProductById() {
        product = productService.getProductById(4L).orElse(null);
        System.out.println(product);
        assertNotNull(product);
    }


    @Test
    @DisplayName("Update Inventory and product")
    @Order(4)
    @Transactional
    @Rollback(value = false)
    void updateProduct(){
        Product productUpdated = productService.getProductById(product.getId()).orElse(null);
        assertNotNull(productUpdated);
        Inventory inventory = inventoryService.getInventoryById(product.getInventory().getId());
        inventory.setQuantityInStock(10);
        productUpdated.setInventory(inventory);
        productUpdated.setName("Updated Product");
        assertNotEquals(product,productService.saveProduct(productUpdated));
    }
    @Test
    @DisplayName("Delete product And Name")
    @Transactional
    @Order(5)
    void deleteProductById() throws Throwable {
        productService.deleteProductById(12l);
        assertFalse(productService.getProductById(12l).isPresent());
    }

    @Test
    @Transactional
    @DisplayName("Get All Product with stock and saled")
    @Order(6)
    void getAllProducts() {
        List<Product> products = productService.getAllProducts();
        products.forEach(product1 -> System.out.println(product1 +" "+ product1.getInventory()));
        assertFalse(products.isEmpty());
    }





}