package com.artjpa.service.impl;

import com.artjpa.AppConfig.ApplicationConfig;
import com.artjpa.entities.Customer;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationConfig.class)
class CustomerServiceImplTest {
    @Autowired
    CustomerServiceImpl costumerService;

    @Test
    void addCostumer() {
        createMoroccanCustomers(6).forEach(customer -> {
            costumerService.addCostumer(customer);
        });


    }

    @Test
    void updateCostumer() throws Throwable {
        Customer customer = costumerService.getCostumerById(1l).orElse(null);
        assertNotNull(customer);
        customer.setName("Nabil Mix");
        assertNotNull(costumerService.updateCostumer(customer.getId(),customer));
    }

    @Test
    void deleteCostumerById() throws Throwable {
     costumerService.deleteCostumerById(6l);

    }

    @Test
    @Transactional
    void getAllCostumers() {
        List<Customer> customers = costumerService.getAllCostumers();
        assumeFalse(customers.isEmpty());
        customers.forEach(customer -> {
            System.out.println(customer.getOrders().size());
        });    }

    @Test
    void getCostumerById() {
        Customer customer = costumerService.getCostumerById(1l).orElse(null);
        assertNotNull(customer);
    }
    List<Customer> createMoroccanCustomers(int count) {
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String name = "Client Maroc " + (i + 1);
            String address = "Adresse Maroc " + (i + 1);
            String phone = "21234541"+(i + 2)+(i + 5) + (i + 1);
            String email = "Email"+(i + 2)+(i + 5) + (i + 1)+"@example.com";
            Customer customer = new Customer();
            customer.setAdress(address);
            customer.setPhone(phone);
            customer.setName(name);
            customer.setEmail(email);
            customers.add(customer);

        }
        return customers;
    }
}