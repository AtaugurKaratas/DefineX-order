package com.order.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Customer {
    private int id;
    private String name;
    private String surname;
    private LocalDate registrationDate;

    public Customer(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.registrationDate = java.time.LocalDate.now();
    }
}
