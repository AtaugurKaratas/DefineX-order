package com.order.dao.impl;

import com.order.dao.BillDao;
import com.order.model.Bill;
import com.order.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BIllImpl implements BillDao {
    @Override
    public String saveBill(Bill bill) {
        try{
            Connection connection = DBUtil.connection();
            String saveProduct = "Insert into bill (total_price, bill_date, order_id, customer_id) values (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(saveProduct);
            preparedStatement.setDouble(1, bill.getTotalPrice());
            preparedStatement.setDate(2, Date.valueOf(bill.getDate()));
            preparedStatement.setInt(3, bill.getOrder_id());
            preparedStatement.setInt(4, bill.getCustomer_id());
            preparedStatement.executeUpdate();
            DBUtil.close(connection, preparedStatement, null);
            return "Bill Saved";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Failed";
    }

    @Override
    public List<Bill> allBills() {
        List<Bill> billList = new ArrayList<>();
        try {
            Connection connection = DBUtil.connection();
            String customers = "Select * from bill";
            PreparedStatement preparedStatement = connection.prepareStatement(customers);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setId(rs.getInt("id"));
                bill.setTotalPrice(rs.getDouble("total_price"));
                bill.setDate(rs.getDate("bill_date").toLocalDate());
                bill.setOrder_id(rs.getInt("order_id"));
                bill.setCustomer_id(rs.getInt("customer_id"));
                bill.setCustomer_id(rs.getInt("company_id"));
                billList.add(bill);
            }
            DBUtil.close(connection, preparedStatement, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return billList;
    }

    @Override
    public List<Bill> allBillsBiggerThanValue(int value) {
        List<Bill> billList = new ArrayList<>();
        try {
            Connection connection = DBUtil.connection();
            String customers = "Select * from bill where total_price > ?";
            PreparedStatement preparedStatement = connection.prepareStatement(customers);
            preparedStatement.setDouble(1, value);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setId(rs.getInt("id"));
                bill.setTotalPrice(rs.getDouble("total_price"));
                bill.setDate(rs.getDate("bill_date").toLocalDate());
                bill.setOrder_id(rs.getInt("order_id"));
                bill.setCustomer_id(rs.getInt("customer_id"));
                bill.setCustomer_id(rs.getInt("company_id"));
                billList.add(bill);
            }
            DBUtil.close(connection, preparedStatement, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return billList;
    }

    @Override
    public double allBillsAverageBiggerThanValue(int value) {
        int average = 0;
        int count = 0;
        try {
            Connection connection = DBUtil.connection();
            String customers = "Select * from bill where total_price > ?";
            PreparedStatement preparedStatement = connection.prepareStatement(customers);
            preparedStatement.setDouble(1, value);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                average += rs.getDouble("total_price");
                count++;
            }
            DBUtil.close(connection, preparedStatement, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(count == 0)
            count = 1;
        return (average/count);
    }

    @Override
    public double billsTotalPriceMonth(List<Integer> customerId) {
        double totalPrice = 0;
        for(int i : customerId) {
            try {
                Connection connection = DBUtil.connection();
                String customers = "Select * from bill where customer_id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(customers);
                preparedStatement.setInt(1, i);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    totalPrice += rs.getDouble("total_price");
                }
                DBUtil.close(connection, preparedStatement, rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return totalPrice;
    }

    @Override
    public List<Integer> allBillsTotalPriceSmallerThan(int value) {
        List<Integer> list = new ArrayList<>();
        try {
            Connection connection = DBUtil.connection();
            String customers = "Select id from bill where total_price < ?";
            PreparedStatement preparedStatement = connection.prepareStatement(customers);
            preparedStatement.setDouble(1, value);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                list.add(rs.getInt("id"));
            }
            DBUtil.close(connection, preparedStatement, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Integer> billsAveragePriceSmallerThanAndMonth(int value, int month) {
        List<Integer> list = new ArrayList<>();
        try {
            Connection connection = DBUtil.connection();
            String customers = "Select company_id from bill where extract (month from bill_date) = ? group by id having avg(total_price) < ?";
            PreparedStatement preparedStatement = connection.prepareStatement(customers);
            preparedStatement.setInt(1, month);
            preparedStatement.setDouble(2, value);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                list.add(rs.getInt("company_id"));
            }
            DBUtil.close(connection, preparedStatement, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
