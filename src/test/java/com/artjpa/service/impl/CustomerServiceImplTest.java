package com.artjpa.service.impl;

import com.artjpa.AppConfig.ApplicationConfig;
import com.artjpa.entities.Customer;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationConfig.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerServiceImplTest {
    @Autowired
    CustomerServiceImpl costumerService;
    static List<Customer> customers;
    Customer customerDb = new Customer();
    long id;

    @BeforeAll
    static void setUp() {
        System.out.println("BEfore ALL");
        customers = new ArrayList<>();
    }

    @BeforeEach
    void beforeEach() {
        // Charger un client spécifique avant chaque test
        id = 6L;
        customerDb = costumerService.getCostumerById(id).orElse(null);
    }

    @ParameterizedTest
    @Order(1)
    @DisplayName("Get Customers from csv file")
    @CsvFileSource(resources = "/customer.csv", delimiter = ',')
    void getListCustomerFromCsvFile(String name, String email, String phone, String address) {
        System.out.println("getListCustomerFromCsvFile");
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhone(phone);
        customer.setAdress(address);
        assertNotNull(customer);
        customers.add(customer);


    }

    @Test
    @Order(2)
    @DisplayName("Add costumer list to database")
    void addCostumer() {
        System.out.println("Add cosutmer list to database");

        customers.forEach(customer -> {
            costumerService.addCostumer(customer);

        });

    }


    @Test
    @DisplayName("Get Ranodm Customer from the data base")
    @Order(3)
    void getCostumerById() {
        id = 3l;
        customerDb = costumerService.getCostumerById(id).orElse(null);
        assertNotNull(customerDb, "Customer from db is null");
        System.out.println(customerDb);
    }

    @Test
    @DisplayName("update the custome then ckeck if is updated")
    @Order(4)
    @Transactional
    void updateCostumer() throws Throwable {
        System.out.println(customerDb);

        // Assurez-vous que customerDb n'est pas null avant de l'utiliser
        assertNotNull(customerDb, "Le client de la base de données est null");

        System.out.println(customerDb.getId());

        Customer customerUpdate = costumerService.getCostumerById(customerDb.getId()).orElse(null);
        assumeFalse(customerUpdate == null);
        customerUpdate.setName("xxx");
        customerUpdate.setEmail("Em2xxxxail@Exasadasdasssmple.com");
        Customer savedCustomer = costumerService.updateCostumer(customerDb.getId(), customerUpdate);
        assertEquals(customerUpdate.getName(), savedCustomer.getName());
        assertEquals(customerUpdate.getEmail(), savedCustomer.getEmail());


    }

    @Test
    @Order(5)
    @DisplayName("Delete customer from db")
    void deleteCostumerById() throws Throwable {
        costumerService.deleteCostumerById(700L);
        assertFalse(costumerService.getCostumerById(700L).isPresent(), "Le client devrait être supprimé de la base de données");

    }

    @Test
    @Order(6)
    @DisplayName("Get All Customers")
    void getAllCostumers() {
        List<Customer> customersList = costumerService.getAllCostumers();
        assertNotEquals(customersList.size(), customers.size());

    }


    @Test
    void getCostumerOrders() {
    }
}