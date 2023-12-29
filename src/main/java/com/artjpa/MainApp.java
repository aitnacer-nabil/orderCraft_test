package com.artjpa;

import com.artjpa.AppConfig.ApplicationConfig;
import com.artjpa.entities.User;
import com.artjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.AnnotationConfigBeanDefinitionParser;

public class MainApp {

    public static void main(String[] args) {
        ApplicationContext context= new AnnotationConfigApplicationContext(ApplicationConfig.class);
        UserRepository userRepository =(UserRepository) context.getBean("userRepository");
        User user = new User("Nabil");
        User user1 = new User("yassine");
        User user2 = new User("youssef");
        User user3 = new User("sami");
        userRepository.save(user3);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.findAll().forEach(System.out::println);
    }
}
