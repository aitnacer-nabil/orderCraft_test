package com.artjpa.service.impl;

import com.artjpa.AppConfig.ApplicationConfig;
import com.artjpa.entities.Inventory;
import com.artjpa.entities.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private InventoryServiceImpl inventoryService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getProductById() {
        Product product = productService.getProductById(3L).orElse(null);
        System.out.println(product);
        assertNotNull(product);
    }

    @RepeatedTest(3)
    void saveProduct() {
//        ('Ensemble de Vaisselle Cuivrée', 'Ensemble de vaisselle en cuivre martelé', 750.50, 18),
//        ('Manteau en Velours', 'Manteau en velours traditionnel marocain', 920.00, 12),
//        ('Table en Noyer', 'Table en bois de noyer avec incrustations', 880.99, 15),
//        ('Lanterne Mauresque Géante', 'Lanterne mauresque géante en fer forgé', 720.00, 8)
        Inventory inventory = new Inventory();
        inventory.setQuantityInStock((int) Math.round(Math.random()));
        inventory.setQuantitySales(0);

        Product product = new Product();
        product.setPrice(new BigDecimal(920));
        product.setDescription("Ensemble de vaisselle en cuivre martelé"+Math.random());
        product.setName("Ensemble de Vaisselle Cuivrée"+Math.random());
        inventory.setProduct(product);
        product.setInventory(inventory);
        Product product1= productService.saveProduct(product).orElse(null);
        assumeTrue(product1 != null,"Product return null after saving");


//        Product product2 = new Product();
//        product2.setPrice(new BigDecimal(920));
//        product2.setDescription("Ensemble de vaisselle en cuivre martelé");
//        product2.setName("Ensemble de Vaisselle Cuivrée");
//        product2.setInventory(inventorySaved);
//        Product product3= productService.saveProduct(product).orElse(null);
//        assertNotNull(product3);
    }
    @Test
    void updateProduct(){
        Product product = productService.getProductById(3L).orElse(null);
        Inventory inventory = inventoryService.getInventoryById(product.getInventory().getId());
        inventory.setQuantityInStock(10);
        inventoryService.saveInventory(inventory);
    }
    @Test
    void deleteProductById() {
        Stream.of(1L,2L,4L,5L,6L).forEach(id->productService.deleteProductById(id));
    }

    @Test
    void getAllProducts() {
        List<Product> products = productService.getAllProducts();
        products.forEach(System.out::println);
    }

    @Test
    void pagination() {
    }

    @Test
    void sortingByMultipleFields() {
    }
}