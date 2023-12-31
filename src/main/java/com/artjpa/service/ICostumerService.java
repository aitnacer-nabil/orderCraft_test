package com.artjpa.service;

import com.artjpa.entities.Customer;
import com.artjpa.entities.Order;

import java.util.List;
import java.util.Optional;

public interface ICostumerService {

     Customer addCostumer(Customer customer) ;

    Customer updateCostumer(long id, Customer customer) throws Throwable;
    void deleteCostumerById(long id) throws Throwable;
    List<Customer> getAllCostumers();
    Optional<Customer> getCostumerById(long id);
    List<Order> getCostumerOrders(Customer customer);

}
