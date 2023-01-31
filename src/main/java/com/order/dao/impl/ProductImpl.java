package com.order.dao.impl;

import com.order.dao.ProductDao;
import com.order.model.Product;
import com.order.util.DBUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductImpl implements ProductDao {
    @Override
    public String saveProduct(Product product) {
        try{
            Connection connection = DBUtil.connection();
            String saveProduct = "Insert into product (name, price, category_id, company_id) values (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(saveProduct);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getCategory_id());
            preparedStatement.setInt(4, product.getCompany_id());
            preparedStatement.executeUpdate();
            DBUtil.close(connection, preparedStatement, null);
            return "Product Saved";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Failed";
    }
}
