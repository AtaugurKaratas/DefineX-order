package com.order.model;

import lombok.Data;

@Data
public class Product {
    private int id;
    private String name;
    private Double price;
    private int category_id;
    private int company_id;

    public Product(String name, Double price, int category_id, int company_id) {
        this.name = name;
        this.price = price;
        this.category_id = category_id;
        this.company_id = company_id;
    }
}
