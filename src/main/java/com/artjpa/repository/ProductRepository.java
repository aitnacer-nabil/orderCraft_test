package com.artjpa.repository;

import com.artjpa.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findByName(String name);
}
