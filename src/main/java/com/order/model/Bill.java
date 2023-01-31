package com.order.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Bill {
    private int id;
    private Double totalPrice;
    private LocalDate date;
    private int order_id;
    private int customer_id;
    private int company_id;

    public Bill(Double totalPrice, LocalDate date, int order_id, int customer_id, int company_id) {
        this.totalPrice = totalPrice;
        this.date = date;
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.company_id = company_id;
    }
}
