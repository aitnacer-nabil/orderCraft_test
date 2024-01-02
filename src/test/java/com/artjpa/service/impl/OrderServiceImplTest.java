package com.artjpa.service.impl;

import com.artjpa.AppConfig.ApplicationConfig;
import com.artjpa.entities.Customer;
import com.artjpa.entities.Order;
import com.artjpa.entities.OrderItem;
import com.artjpa.entities.Product;
import javax.transaction.Transactional;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assumptions.*;
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationConfig.class)
class OrderServiceImplTest {
    @Autowired
    CustomerServiceImpl customerService;
    @Autowired
    ProductServiceImpl productService;
    @Autowired
    OrderServiceImpl orderService;
    @Autowired
    OrderItemService orderItemService;



    @Transactional
    @Rollback(value = false)
    @RepeatedTest(3)
    void createOrder() {
        Customer customer = customerService.getCostumerById(1).orElse(null);
        assumeTrue(customer != null, "Aucun client trouvé pour cet ID 1");

        Product product = productService.getProductById(1L).orElse(null);
        assumeTrue(product != null, "Aucun produit trouvé pour cet ID 1");

        assumeTrue(product.getInventory().getQuantityInStock() >= 12, "Quantité insuffisante en stock");

        product.getInventory().setQuantitySales(12);

        assumeTrue(product.getInventory().getQuantityInStock() >= 0, "Quantité en stock ne peut pas être négative");

        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setQuantity(12);

        Order order = new Order();
        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(orderItem);
        assumeFalse(orderItems.isEmpty());

        order.setOrderItems(orderItems);
        order.setCustomer(customer);
        order.setStatus("PREPARATION");
        order.setTotalPrice(order.getTotalOrderItems());
        orderItem.setOrder(order);
        assertNotNull(orderService.createOrder(order));
    }

    @Test
    void getOrder() throws Throwable {
        Order order = orderService.getOrder(3l);
        assumeTrue(order != null);
        System.out.println(order);
    }

    @Test
    void getAllOrders() {
    }

    @Test
    void updateOrder() {
    }

    @Test
    void deleteOrder() {
    }
}