package com.order.model;

import lombok.Data;

@Data
public class Company {
    private int id;
    private String name;
    private int sector_id;

    public Company(String name, int sector_id) {
        this.name = name;
        this.sector_id = sector_id;
    }
}
