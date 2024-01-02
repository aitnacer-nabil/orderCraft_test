package com.artjpa.controller;


import com.artjpa.entities.Customer;
import com.artjpa.service.impl.CustomerServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    CustomerServiceImpl customerService;
    @Autowired
    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }
    @GetMapping("/new")
    public String showAddForm(Model model) {

        model.addAttribute("customer", new Customer());
        return "customer-form";
    }
    @PostMapping("/insert")
    public String insertCustomer(@ModelAttribute("customer") Customer customer) {

        customerService.addCostumer(customer);
        return "redirect:/customer/list";
    }
    @PostMapping("/update")
    public String updateClient(@RequestParam("id") String id, @ModelAttribute("customer") Customer customer) throws Throwable {

        customerService.updateCostumer(Long.parseLong(id),customer);
        return "redirect:/customer/list";
    }
    @GetMapping("/edit")
    public String showEditForm(@RequestParam("id") String id, Model model) {
        Customer customer = customerService.getCostumerById(Long.parseLong(id)).get();
        model.addAttribute("customer", customer);
        return "customer-form";
    }

    @GetMapping({"/", "/list"})
    public String listClients(Model model) {
        List<Customer> customers = customerService.getAllCostumers();
        model.addAttribute("listCustomers", customers);

        return "customer";
    }

    @GetMapping("/delete")
    public String deleteClient(@RequestParam("id") String id) throws Throwable {

        customerService.deleteCostumerById(Long.parseLong(id));
        return "redirect:/customer/list";
    }
}