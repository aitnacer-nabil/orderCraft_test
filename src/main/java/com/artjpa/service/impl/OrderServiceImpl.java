package com.artjpa.service.impl;

import com.artjpa.entities.Order;
import com.artjpa.repository.OrderRepository;
import com.artjpa.service.IOrderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    OrderRepository orderRepository;
    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override

    public Order getOrder(Long id) throws Throwable {
        isExitsOrThrowExcp(id);
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order updateOrder(Order order) throws Throwable {
        isExitsOrThrowExcp(order.getId());
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id) throws Throwable {
        isExitsOrThrowExcp(id);
        orderRepository.deleteById(id);

    }
    private void isExitsOrThrowExcp(long id) throws Throwable {
        if (!orderRepository.existsById(id)) throw new Throwable("Not Order fond with this id " + id);

    }
}
