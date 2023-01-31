package com.order.dao;

import com.order.model.Customer;

import java.util.List;

public interface CustomerDao {
    String saveCustomer(Customer customer);
    List<Customer> allCustomers();
    List<Customer> allCustomerContainsValue(String value);
    List<Integer> customerIdSearchMonth(int month);
    List<Customer> customersListById(List<Integer> integerList);
}
