package com.artjpa;

import com.artjpa.AppConfig.ApplicationConfig;
import com.artjpa.entities.Product;
import com.artjpa.entities.User;
import com.artjpa.repository.ProductRepository;
import com.artjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.AnnotationConfigBeanDefinitionParser;

import java.math.BigDecimal;

public class MainApp {

    public static void main(String[] args) {
        ApplicationContext context= new AnnotationConfigApplicationContext(ApplicationConfig.class);
        UserRepository userRepository =(UserRepository) context.getBean("userRepository");
        ProductRepository productRepository = (ProductRepository)context.getBean("productRepository");

        Product product = new Product();
        product.setName("Morccan Leg");
        product.setDescription("Morccan Table from agadir");
        product.setQteStock(10);
        product.setPrice(new BigDecimal("120.5"));
        Product saved =  productRepository.findByName(product.getName());
        System.out.println(saved);



    }
}
