package com.order.dao.impl;

import com.order.dao.CompanyDao;
import com.order.model.Company;
import com.order.util.DBUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CompanyImpl implements CompanyDao {
    @Override
    public String saveCompany(Company company) {
        try{
            Connection connection = DBUtil.connection();
            String saveCompany = "Insert into company (name, sector_id) values (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(saveCompany);
            preparedStatement.setString(1, company.getName());
            preparedStatement.setInt(2, company.getSector_id());
            preparedStatement.executeUpdate();
            DBUtil.close(connection, preparedStatement, null);
            return "Company Saved";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Failed";
    }
}
