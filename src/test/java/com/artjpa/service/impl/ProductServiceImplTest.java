package com.artjpa.service.impl;

import com.artjpa.AppConfig.ApplicationConfig;
import com.artjpa.entities.Inventory;
import com.artjpa.entities.Product;
import jakarta.transaction.Transactional;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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

    @Test
    void saveProduct() {
//        ('Ensemble de Vaisselle Cuivrée', 'Ensemble de vaisselle en cuivre martelé', 750.50, 18),
//        ('Manteau en Velours', 'Manteau en velours traditionnel marocain', 920.00, 12),
//        ('Table en Noyer', 'Table en bois de noyer avec incrustations', 880.99, 15),
//        ('Lanterne Mauresque Géante', 'Lanterne mauresque géante en fer forgé', 720.00, 8)
        for (int i = 11; i < 20; i++) {
            String name = "Produit Maroc " + (i + 1);
            String description = "Description du produit Maroc " + (i + 1);
            BigDecimal price = BigDecimal.valueOf(getRandomInt(10, 100));
            Inventory inventory = new Inventory();
            inventory.setQuantityInStock(getRandomInt(4,25));

            Product product = new Product();
            product.setPrice(price);
            product.setDescription(description);
            product.setName(name);
            inventory.setProduct(product);
            product.setInventory(inventory);
            Product product1= productService.saveProduct(product).orElse(null);
            assertNotNull(product1);

        }


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
        assertNotNull(product);
        Inventory inventory = inventoryService.getInventoryById(product.getInventory().getId());
        inventory.setQuantityInStock(10);
        inventoryService.saveInventory(inventory);
    }
    @Test
    void deleteProductById() throws Throwable {
        productService.deleteProductById(10l);
    }

    @Test
    @Transactional
    void getAllProducts() {
        List<Product> products = productService.getAllProducts();
        products.forEach(product -> System.out.println(product.getOrderItemSet()));
    }


    int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
    List<Product> createMoroccanProducts(int count) {
        List<Product> products = new ArrayList<>();

        return products;
    }


}