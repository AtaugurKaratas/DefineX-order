package com.order.dao;

import com.order.model.Order;

public interface OrderDao {
    String saveOrder(Order order);
}
