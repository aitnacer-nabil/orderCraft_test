package com.artjpa.service.impl;

import com.artjpa.entities.OrderItem;
import com.artjpa.repository.OrderItemRepository;
import com.artjpa.service.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService implements IOrderItemService {

    @Autowired
    OrderItemRepository orderItemRepository;

    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public OrderItem getOrderItem(Long id) throws Throwable {
        isExitsOrThrowExcp(id);
        return orderItemRepository.findById(id).orElse(null);
    }

    @Override
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    @Override
    public OrderItem updateOrderItem(OrderItem orderItem) throws Throwable {
        isExitsOrThrowExcp(orderItem.getId());
        return orderItemRepository.save(orderItem);
    }

    @Override
    public void deleteOrderItem(Long id) throws Throwable {
        isExitsOrThrowExcp(id);
    }
    private void isExitsOrThrowExcp(long id) throws Throwable {
        if (!orderItemRepository.existsById(id)) throw new Throwable("Not Costumer fond with this id " + id);
    }
}
