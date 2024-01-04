package com.artjpa.service.impl;

import com.artjpa.AppConfig.ApplicationConfig;
import com.artjpa.entities.Customer;
import com.artjpa.entities.Order;
import com.artjpa.entities.OrderItem;
import com.artjpa.entities.Product;
import com.artjpa.entities.mock.CustomerMock;
import org.junit.jupiter.api.Order;

import jakarta.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
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
import java.util.Optional;

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
    
    @Test 
    @Rollback(value = false)
    @Transactional
    @DisplayName("Test createOrder method")    
    void createOrder() {
        Customer customer = customerService.getCostumerById(15L).orElse(null);    	 
        assumeTrue(customer != null, "Aucun client trouvé pour cet ID 15");
        Product product = productService.getProductById(1L).orElse(null);
        System.out.println("produit: "+product);
        assumeTrue(product != null, "Aucun produit trouvé pour cet ID 1");
        assumeTrue(product.getInventory().getQuantityInStock() >= 12, "Quantité insuffisante en stock");

        product.getInventory().setQuantitySales(12);

        assumeTrue(product.getInventory().getQuantityInStock() >= 0, "Quantité en stock ne peut pas être négative");
        System.out.println("produit apres set qteSales: "+product);
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setQuantity(12);
        orderItemService.createOrderItem(orderItem);
        Order order = new Order();
        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(orderItem);
        assumeFalse(orderItems.isEmpty());

        order.setOrderItems(orderItems);
        order.setCustomer(customer);
        customer.getOrders().add(order);
        order.setStatus("PREPARATION");
        order.setTotalPrice(order.getTotalOrderItems());
        orderItem.setOrder(order);
        System.out.println("orderOItem: "+orderItem);
        assertNotNull(orderService.createOrder(order));
        System.out.println(order);
    }

    @Test
    @Rollback(value = false)
    @DisplayName("Test getOrder method")
    void getOrder() throws Throwable {
        Order order = orderService.getOrder(8l);
        assumeTrue(order != null);
        System.out.println(order);
    }

    @Test
    @Rollback(value = false)
    @DisplayName("Test getAllOrders method")
    void getAllOrders() {
    	List<Order> orders = orderService.getAllOrders();
        assumeFalse(orders.isEmpty());
        //assumeFalse(customers.size()<=0);
        orders.forEach(System.out::println);
    }

    @Test
    @Rollback(value = false)
    @DisplayName("Test updateOrder method")
    void updateOrder() throws Throwable {
            Order order = orderService.getOrderById(9L).orElse(null);
            assertNotNull(order);
            order.setStatus("COMPLETE");
            assertNotNull(orderService.updateOrder(order.getId(),order));
    }
 
    @Test
    @Rollback(value = false)
    @DisplayName("Test deleteOrder method")
    void deleteOrderById() throws Throwable {

     orderService.deleteOrder(9L);
     Order order1 = null;
     Optional<Order> optionalOrder = orderService.getOrderById(9L);
     if(optionalOrder.isPresent()){
           order1 = optionalOrder.get();
     }
     Assertions.assertNull(order1);
    }
}