package com.artjpa.service;

import com.artjpa.entities.Order;

import java.util.List;
import java.util.Optional;

public interface IOrderService {

    Order createOrder(Order order);
    Order getOrder(Long id) throws Throwable;
    List<Order> getAllOrders();
    Order updateOrder(Order order) throws Throwable;
    void deleteOrder(Long id) throws Throwable;
    public Optional<Order> getOrderById(long id);
    public Order updateOrder(long id, Order order) throws Throwable;
}
