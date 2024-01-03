package com.artjpa.service.impl;

import com.artjpa.AppConfig.ApplicationConfig;
import com.artjpa.entities.Customer;
import com.artjpa.entities.mock.CustomerMock;

import jakarta.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationConfig.class)
class CustomerServiceImplTest {
    @Autowired
    CustomerServiceImpl costumerService;
    
    
    @Test
    @DisplayName("Test addCostumer method")
    @Order(1)
    @Rollback(value = false)
    void addCostumer() {
    	/*Customer customer = Customer.builder()
                .name("Ram")
                .adress("adress123")
                .email("ram@gmail.com")
                .phone("00000000")
                .orders(null)
                .build();*/
    	 Customer customer = CustomerMock.mockRequest();
    System.out.println("customer moock: "+customer);
    	costumerService.addCostumer(customer);

        Assertions.assertFalse(customer.getId()<=0);    
    
    }

    @Test
    @DisplayName("Test updateCostumer method")
    void updateCostumer() throws Throwable {
        Customer customer = costumerService.getCostumerById(10L).orElse(null);
        assertNotNull(customer);
        customer.setName("NaMix");
        assertNotNull(costumerService.updateCostumer(customer.getId(),customer));
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    @DisplayName("Test deleteCostumer method")
    void deleteCostumerById() throws Throwable {

     costumerService.deleteCostumerById(10L);
     Customer customer1 = null;
     Optional<Customer> optionalCustomer = costumerService.getCostumerById(10L);
     if(optionalCustomer.isPresent()){
           customer1 = optionalCustomer.get();
     }
     Assertions.assertNull(customer1);
    }

    @Test
    @Transactional
    @DisplayName("Test getAllCostumer method")
    void getAllCostumers() {
        List<Customer> customers = costumerService.getAllCostumers();
        assumeFalse(customers.isEmpty());
        //assumeFalse(customers.size()<=0);
        customers.forEach(System.out::println);
       }

    @Test
    @DisplayName("Test getCostumerById method")
    void getCostumerById() {
        Customer customer = costumerService.getCostumerById(11l).orElse(null);
        assertNotNull(customer);
    }
   /* List<Customer> createMoroccanCustomers(int count) {
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
    }*/
}