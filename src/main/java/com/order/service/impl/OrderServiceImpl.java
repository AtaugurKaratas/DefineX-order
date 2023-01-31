package com.order.service.impl;

import com.order.dao.impl.OrderImpl;
import com.order.model.Order;
import com.order.service.OrderService;

public class OrderServiceImpl implements OrderService {
    @Override
    public String saveOrder(Order order) {
        OrderImpl orderImpl = new OrderImpl();
        return orderImpl.saveOrder(order);
    }
}
