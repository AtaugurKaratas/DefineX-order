package com.order.service;

import com.order.model.Customer;

import java.util.List;

public interface CustomerService {
    String saveCustomer(Customer customer);
    List<Customer> allCustomers();
    List<Customer> allCustomerContainsValue(String value);
    double customerIdSearchMonth(int month);
    List<Customer> customersListById(List<Integer> integerList);
}
