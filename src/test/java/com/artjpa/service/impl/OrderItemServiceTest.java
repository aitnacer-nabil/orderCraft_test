package com.artjpa.service.impl;

import com.artjpa.AppConfig.ApplicationConfig;
import com.artjpa.entities.*;
import com.artjpa.repository.OrderItemRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.slf4j.LoggerFactoryFriend.reset;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationConfig.class)
class OrderItemServiceTest {
    @Autowired
   OrderItemService orderItemService ;
    private Object OrderItemRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    @Transactional
    void createOrderItem() {
        OrderItem orderItem = new OrderItem();
        Product product = new Product();
        Inventory inventory = new Inventory();
        Customer  customer = new Customer();
        customer.setName("nom");
        customer.setAdress("adress");
        customer.setEmail("name@gmail.com");
        customer.setPhone("0677");
        inventory.setQuantityInStock(40);
        product.setDescription("new pro");
        product.setPrice(BigDecimal.valueOf(20.2));
        product.setInventory(inventory);
        product.setName("indomi");
        inventory.setProduct(product);
        Order order  = new Order();
        order.setCustomer(customer);
        orderItem.setProduct(product);
        orderItem.setOrder(order);
        orderItem.setQuantity(10);
        assertNotNull(orderItem);
        orderItemService.createOrderItem(orderItem);
        assertEquals(1 ,orderItem.getId());

    }

    @Test
    void getOrderItem() throws Throwable {
    OrderItem orderItem = orderItemService.getOrderItem((long) 1);
        assertNotNull(orderItem);
       assertInstanceOf(OrderItem.class ,orderItem);
    }

    @Test
    void getAllOrderItems() {
        List<OrderItem> orderItems = orderItemService.getAllOrderItems();
        assertFalse(orderItems.isEmpty());
        assertEquals(1, orderItems.size());
    }

    @Test
    void updateOrderItem() throws Throwable {
        OrderItem orderItem = orderItemService.getOrderItem((long) 1);
        assertNotNull(orderItem);
        orderItem.setQuantity(6);
        orderItemService.updateOrderItem(orderItem);
        OrderItem orderItem1 = orderItemService.getOrderItem((long) 1);
        assertNotNull(orderItem);
        assertEquals(6,orderItem1.getQuantity());

    }

    @Test
    void deleteOrderItem() throws Throwable {
        orderItemService.deleteOrderItem(1L);
        OrderItem orderItem = orderItemService.getOrderItem((long) 1);
        assertNull(orderItem);

    }



}