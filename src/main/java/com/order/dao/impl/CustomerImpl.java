package com.order.dao.impl;

import com.order.dao.CustomerDao;
import com.order.model.Customer;
import com.order.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerImpl implements CustomerDao {
    @Override
    public String saveCustomer(Customer customer) {
        try {
            Connection connection = DBUtil.connection();
            String saveCustomer = "Insert into customer (name, surname, registration_date) values (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(saveCustomer);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getSurname());
            preparedStatement.setDate(3, Date.valueOf(customer.getRegistrationDate()));
            preparedStatement.executeUpdate();
            DBUtil.close(connection, preparedStatement, null);
            return "Customer Saved";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Failed";
    }

    @Override
    public List<Customer> allCustomers() {
        List<Customer> customerList = new ArrayList<>();
        try {
            Connection connection = DBUtil.connection();
            String customers = "Select * from customer";
            PreparedStatement preparedStatement = connection.prepareStatement(customers);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setSurname(rs.getString("surname"));
                customer.setRegistrationDate(rs.getDate("registration_date").toLocalDate());
                customerList.add(customer);
            }
            DBUtil.close(connection, preparedStatement, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public List<Customer> allCustomerContainsValue(String value) {
        List<Customer> customerList = new ArrayList<>();
        try {
            Connection connection = DBUtil.connection();
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from customer where name like ?");
            preparedStatement.setString(1, ("%" + value + "%"));
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setSurname(rs.getString("surname"));
                customer.setRegistrationDate(rs.getDate("registration_date").toLocalDate());
                customerList.add(customer);
            }
            DBUtil.close(connection, preparedStatement, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public List<Integer> customerIdSearchMonth(int month) {
        List<Integer> customerIdList = new ArrayList<>();
        try {
            Connection connection = DBUtil.connection();
            PreparedStatement preparedStatement = connection.prepareStatement("Select id from customer where extract (month from registration_date) = ?");
            preparedStatement.setInt(1, month);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                customerIdList.add(rs.getInt("id"));
            }
            DBUtil.close(connection, preparedStatement, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerIdList;
    }

    @Override
    public List<Customer> customersListById(List<Integer> integerList) {
        List<Customer> customerList = new ArrayList<>();
        for (int i : integerList) {
            try {
                Connection connection = DBUtil.connection();
                PreparedStatement preparedStatement = connection.prepareStatement("Select * from customer where id = ?");
                preparedStatement.setInt(1, i);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    Customer customer = new Customer();
                    customer.setId(rs.getInt("id"));
                    customer.setName(rs.getString("name"));
                    customer.setSurname(rs.getString("surname"));
                    customer.setRegistrationDate(rs.getDate("registration_date").toLocalDate());
                    customerList.add(customer);
                }
                DBUtil.close(connection, preparedStatement, rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return customerList;
    }
}
