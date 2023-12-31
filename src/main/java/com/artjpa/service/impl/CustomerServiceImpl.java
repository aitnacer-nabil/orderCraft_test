package com.artjpa.service.impl;

import com.artjpa.entities.Customer;
import com.artjpa.entities.Order;
import com.artjpa.repository.CustomerRepository;
import com.artjpa.service.ICustomerService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer addCostumer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCostumer(long id, Customer customer) throws Throwable {
        isExitsOrThrowExcp(id);
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCostumerById(long id) throws Throwable {
        isExitsOrThrowExcp(id);
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> getAllCostumers() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCostumerById(long id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Order> getCostumerOrders(Customer customer) {
       Hibernate.initialize(customer.getOrders());
       return customer.getOrders();

    }

    private void isExitsOrThrowExcp(long id) throws Throwable {
        if (!customerRepository.existsById(id)) throw new Throwable("Not Costumer fond with this id " + id);

    }
}
