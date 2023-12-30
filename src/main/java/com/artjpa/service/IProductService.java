package com.artjpa.service;

import com.artjpa.entities.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {

     Optional<Product> getProductById(Long id);
     Optional<Product> saveProduct(Product product);
     void deleteProductById(Long id);  // Vous n'avez probablement pas besoin d'un Optional pour la suppression
     List<Product> getAllProducts();



}
