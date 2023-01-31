package com.order.model;

import lombok.Data;

@Data
public class Category {
    private int id;
    private String name;

    public Category(String name) {
        this.name = name;
    }
}
