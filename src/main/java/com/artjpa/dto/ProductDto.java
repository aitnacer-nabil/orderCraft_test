package com.artjpa.dto;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class ProductDto {
    private long id;
    private String name;
    private String description;
    private int price;
    private int quantityInStock;
}
