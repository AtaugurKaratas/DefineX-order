package com.order.model;

import lombok.Data;

@Data
public class Order {
    private int id;
    private int product_id;
    private int productCount;
    private int customer_id;

    public Order(int product_id, int productCount, int customer_id) {
        this.product_id = product_id;
        this.productCount = productCount;
        this.customer_id = customer_id;
    }
}
