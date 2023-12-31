package com.artjpa.service;

import com.artjpa.entities.Order;

import java.util.List;

public interface IOrderService {

    Order createOrder(Order order);
    Order getOrder(Long id) throws Throwable;
    List<Order> getAllOrders();
    Order updateOrder(Order order) throws Throwable;
    void deleteOrder(Long id) throws Throwable;
}
