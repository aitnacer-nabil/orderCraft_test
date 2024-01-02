package com.artjpa.service;

import com.artjpa.entities.OrderItem;

import java.util.List;

public interface IOrderItemService {
    OrderItem createOrderItem(OrderItem orderItem);
    OrderItem getOrderItem(Long id) throws Throwable;
    List<OrderItem> getAllOrderItems();
    OrderItem updateOrderItem(OrderItem orderItem) throws Throwable;
    void deleteOrderItem(Long id) throws Throwable;
}
