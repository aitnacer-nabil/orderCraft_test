package com.artjpa.service.impl;

import com.artjpa.AppConfig.ApplicationConfig;
import com.artjpa.entities.Inventory;
import com.artjpa.entities.Product;
import com.artjpa.entities.mock.ProductMock;
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
import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class ProductServiceImplTest {


    @Autowired
    ProductServiceImpl productService;

    @Autowired InventoryServiceImpl inventoryService;

    @Test
    void getProductById() {
        long productId = 3L;
        Product product = productService.getProductById(productId).orElse(null);
        assertNotNull(product);
    }

    @Test
    void saveProduct() {
//        List<Product> productsToSave = Arrays.asList(
//                createProduct("Ensemble de Vaisselle Cuivrée", "Ensemble de vaisselle en cuivre martelé", new BigDecimal("750.50"), 18),
//                createProduct("Manteau en Velours", "Manteau en velours traditionnel marocain", new BigDecimal("920.00"), 12),
//                createProduct("Table en Noyer", "Table en bois de noyer avec incrustations", new BigDecimal("880.99"), 15),
//                createProduct("Lanterne Mauresque Géante", "Lanterne mauresque géante en fer forgé", new BigDecimal("720.00"), 8)
//        );
        List<Product> productsToSave = Arrays.asList(ProductMock.mockRequest());
        for (Product product : productsToSave) {
            Optional<Product> savedProduct = productService.saveProduct(product);
            assertNotNull(savedProduct.orElse(null));
        }
    }
//    private Product createProduct(String name, String description, BigDecimal price, int quantityInStock) {
//        Product product = new Product(name, description, price);
//        Inventory inventory = new Inventory();
//        inventory.setQuantityInStock(quantityInStock);
//        product.setInventory(inventory);
//        inventory.setProduct(product);
//        return product;
//    }

    @Test
    void deleteProductById() throws Throwable {
        productService.deleteProductById(5L);
        Optional<Product> deletedProduct = productService.getProductById(15L);
        assertFalse(deletedProduct.isPresent());
    }

    @Test
    @Transactional
    void getAllProducts() {
        List<Product> products = productService.getAllProducts();
        assertFalse(products.isEmpty());
        products.forEach(product -> System.out.println(product.getOrderItemSet()));
    }

    @Test
    void updateProduct() {
        long productId = 3L;

        Optional<Product> optionalProduct = productService.getProductById(productId);
        assertTrue(optionalProduct.isPresent());
        Product existingProduct = optionalProduct.get();

        Inventory existingInventory = inventoryService.getInventoryById(existingProduct.getInventory().getId());
        assertNotNull(existingInventory);

        existingInventory.setQuantityInStock(10);

        inventoryService.saveInventory(existingInventory);

        Optional<Product> updatedProductOptional = productService.getProductById(productId);
        assertTrue(updatedProductOptional.isPresent());
        Product updatedProduct = updatedProductOptional.get();

        assertEquals(10, updatedProduct.getInventory().getQuantityInStock());
    }
}
