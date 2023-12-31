package com.artjpa.service.impl;

import com.artjpa.AppConfig.ApplicationConfig;
import com.artjpa.entities.Costumer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@DisplayName("Test Costumer Service")
class CostumerServiceImplTest {

    ApplicationContext context= new AnnotationConfigApplicationContext(ApplicationConfig.class);;
    CostumerServiceImpl costumerService = context.getBean(CostumerServiceImpl.class);

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Test Add Costumer To Database")
    @Disabled
    void addCostumer() {
        Costumer costumer = new Costumer();
        costumer.setPhone("1213131w21D");
        costumer.setName("nabilw2");
        costumer.setAdress("Caswa2");
        costumer.setEmail("email2@exwample.com");
        assertNotNull(costumerService.addCostumer(costumer));


    }

    @Test
    void updateCostumer() throws Throwable {
        Costumer costumer = new Costumer();
        costumer.setName("Yassine");
        Optional<Costumer> costumerUpdate = costumerService.getCostumerById(4L);
        assumeTrue(costumerUpdate.isPresent());
        Costumer costumer1updated = costumerService.updateCostumer(4,costumer);
        assertNotNull(costumer1updated);
        assertEquals(costumer.getName(),costumer1updated.getName());

    }

    @Test
    void deleteCostumerById() {
    }

    @Test
    void getAllCostumers() {

    }

    @Test
    void getCostumerById() {
        Costumer costumer = costumerService.getCostumerById(4L).orElse(null);
        assertNotNull(costumer);
    }
}