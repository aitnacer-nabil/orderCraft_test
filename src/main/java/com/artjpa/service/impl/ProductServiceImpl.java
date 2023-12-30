package com.artjpa.service.impl;

import com.artjpa.entities.Product;
import com.artjpa.repository.ProductRepository;
import com.artjpa.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {
    private ProductRepository productRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Optional<Product> saveProduct(Product product) {
        return Optional.of(productRepository.save(product));
    }

    @Override
    public void deleteProductById(Long id) {

    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public void pagination() {
        int pageNo = 0;
        int pageSize = 5;

        //Create pageable
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        //findAll method and pass pageable instance
        Page<Product> page = productRepository.findAll(pageable);
        List<Product> products = page.getContent();
        products.forEach(System.out::println);
        //total Pages
        int totalPages = page.getTotalPages();
        //total elements
        int totalElements = page.getNumberOfElements();
        //size
        int size = page.getSize();
        // last
        boolean last = page.isLast();
        //first
        boolean first = page.isFirst();
        String st ="PAge{" +
                "totalPages=" + totalPages +'\''+
                "totalElements=" + totalElements +'\''+
                "size=" + size +'\''+
                "last=" + last +'\''+
                "first=" + first +'\''+
                '}';

        System.out.println(st);
    }
    public void sortingByMultipleFields(){
        String sortByName = "name";
        String sortByDesc = "description";
        String sortDir = "asc";
        Sort sortBy_Name = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortByName).ascending() : Sort.by(sortByName).descending();
        List<Product> products = productRepository.findAll(sortBy_Name);
        products.forEach(System.out::println);



    }
}
