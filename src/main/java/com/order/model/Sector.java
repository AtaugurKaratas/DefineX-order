package com.order.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Sector {
    private int id;
    private String name;

    public Sector(String name) {
        this.name = name;
    }
}
