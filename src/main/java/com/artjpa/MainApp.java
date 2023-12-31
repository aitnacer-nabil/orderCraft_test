package com.artjpa;

import com.artjpa.AppConfig.ApplicationConfig;
import com.artjpa.entities.Costumer;
import com.artjpa.entities.Product;
import com.artjpa.entities.User;
import com.artjpa.repository.ProductRepository;
import com.artjpa.repository.UserRepository;
import com.artjpa.service.impl.CostumerServiceImpl;
import com.artjpa.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.AnnotationConfigBeanDefinitionParser;

import java.math.BigDecimal;

public class MainApp {

    public static void main(String[] args) {
        ApplicationContext context= new AnnotationConfigApplicationContext(ApplicationConfig.class);;

//        Costumer costumer =new Costumer();
//        costumer.setAdress("Ruse Casa");
//        costumer.setName("Nabil Mix");
//        costumer.setEmail("Nabil@example.com");
//        costumer.setPhone("+21267534023");
//        costumerService.addCostumer(costumer);
//        costumerService.getAllCostumers().forEach(System.out::println);






    }
}
