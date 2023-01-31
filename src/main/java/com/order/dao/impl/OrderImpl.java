package com.order.dao.impl;

import com.order.dao.OrderDao;
import com.order.model.Order;
import com.order.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderImpl implements OrderDao {
    @Override
    public String saveOrder(Order order) {
        try{
            Connection connection = DBUtil.connection();
            String saveProduct = "Insert into order_table (product_id, product_count, customer_id) values (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(saveProduct);
            preparedStatement.setInt(1, order.getProduct_id());
            preparedStatement.setInt(2, order.getProductCount());
            preparedStatement.setInt(3, order.getCustomer_id());
            preparedStatement.executeUpdate();
            DBUtil.close(connection, preparedStatement, null);
            return "Order Saved";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Failed";
    }
}
