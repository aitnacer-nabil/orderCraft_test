package com.artjpa.service.impl;

import com.artjpa.entities.Inventory;
import com.artjpa.entities.Product;
import com.artjpa.repository.InventoryRepository;
import com.artjpa.repository.ProductRepository;
import com.artjpa.service.IProductService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class ProductServiceImpl implements IProductService {
    private ProductRepository productRepository;

    private InventoryRepository inventoryRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, InventoryRepository inventoryRepository) {
        this.productRepository = productRepository;
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    @Transactional
    public Optional<Product> saveProduct(Product product) {


        return Optional.of(productRepository.save(product));
    }

    @Override
    public void deleteProductById(Long id) throws Throwable {
        isExitsOrThrowExcp(id);
     productRepository.deleteById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> updateProduct(Long id, Product product) throws Throwable {
        isExitsOrThrowExcp(id);
        product.setId(id);
        return Optional.of(productRepository.save(product));
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
    private void isExitsOrThrowExcp(long id) throws Throwable {
        if (!productRepository.existsById(id)) throw new Throwable("Not Costumer fond with this id " + id);

    }
}
