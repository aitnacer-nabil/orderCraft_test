package com.artjpa.controller;

import com.artjpa.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    CustomerServiceImpl customerService;
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message",customerService.getCostumerById(1l).toString());
        return "home";
    }
}
