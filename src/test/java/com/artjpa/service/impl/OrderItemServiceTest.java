package com.artjpa.service.impl;

import com.artjpa.AppConfig.ApplicationConfig;
import com.artjpa.entities.OrderItem;
import com.artjpa.entities.Product;
import com.artjpa.entities.mock.ProductMock;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationConfig.class)
class OrderItemServiceTest {

    @Autowired
    OrderItemService orderItemService;

    @Autowired
    ProductServiceImpl productServiceImpl;

    @BeforeEach
    void setUp() {
    }

    @Transactional
    @Rollback
    @Test
    void createOrderItem() {

        long productId = 2L;
        Product product = productServiceImpl.getProductById(productId).orElseThrow(() -> new RuntimeException("Product not found"));

        int quantity = 70;
        BigDecimal amount = product.getPrice().multiply(new BigDecimal(quantity));

        OrderItem orderItem = new OrderItem();
        orderItem.setAmount(amount);
        orderItem.setQuantity(quantity);
        orderItem.setProduct(product);

        OrderItem createOrderItem = orderItemService.createOrderItem(orderItem);

        assertNotNull(createOrderItem);

    }

    @Test
    void getOrderItem() {
    }

    @Test
    void getAllOrderItems() {
    }

    @Test
    void updateOrderItem() {
    }

    @Test
    void deleteOrderItem() {
    }
}