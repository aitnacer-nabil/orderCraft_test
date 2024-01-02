package com.artjpa.controller;

import com.artjpa.dto.ProductDto;
import com.artjpa.entities.Customer;
import com.artjpa.entities.Inventory;
import com.artjpa.entities.Product;
import com.artjpa.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private ProductServiceImpl productService;

    @Autowired
    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {

        model.addAttribute("product", new ProductDto());
        return "product-form";
    }

    @GetMapping({"/","/list"})
    public String listProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("listProducts", products);
        return "product";
    }
    @PostMapping("/insert")
    public String saveProduct(@ModelAttribute("product") ProductDto productDto) {
        Product product = new Product();

        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(new BigDecimal(productDto.getPrice()));

        Inventory inventory = new Inventory();
        inventory.setQuantityInStock(productDto.getQuantityInStock());
        inventory.setProduct(product);

        product.setInventory(inventory);

        productService.saveProduct(product);

        return "redirect:/product/list";
    }


}