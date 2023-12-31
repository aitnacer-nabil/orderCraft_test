package com.artjpa.service;

import com.artjpa.entities.Order;

import java.util.List;

public interface IOrderService {

    Order createOrder(Order order);
    Order getOrder(Long id);
    List<Order> getAllOrders();
    Order updateOrder(Order order);
    void deleteOrder(Long id);
}
