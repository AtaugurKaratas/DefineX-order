package com.order.dao.impl;

import com.order.dao.CategoryDao;
import com.order.model.Category;
import com.order.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoryImpl implements CategoryDao {
    @Override
    public String saveCategory(Category category) {
        try{
            Connection connection = DBUtil.connection();
            String saveCategory = "Insert into category (name) values (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(saveCategory);
            preparedStatement.setString(1, category.getName());
            preparedStatement.executeUpdate();
            DBUtil.close(connection, preparedStatement, null);
            return "Category Saved";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Failed";
    }
}
