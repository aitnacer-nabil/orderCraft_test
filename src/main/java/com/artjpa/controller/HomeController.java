package com.artjpa.controller;

import com.artjpa.entities.Customer;
import com.artjpa.service.impl.CustomerServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    CustomerServiceImpl customerService;

    @Autowired
    public HomeController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"/", "/list"})
    public String listClients(Model model) {


        List<Customer> customers = customerService.getAllCostumers();
        model.addAttribute("listCustomers", customers);

        return "customer";
    }

}
