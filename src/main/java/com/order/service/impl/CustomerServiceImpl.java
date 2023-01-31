package com.order.service.impl;

import com.order.dao.impl.CustomerImpl;
import com.order.model.Customer;
import com.order.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    CustomerImpl customerImpl = new CustomerImpl();

    @Override
    public String saveCustomer(Customer customer) {
        return customerImpl.saveCustomer(customer);
    }

    @Override
    public List<Customer> allCustomers() {
        return customerImpl.allCustomers();
    }

    @Override
    public List<Customer> allCustomerContainsValue(String value) {
        return customerImpl.allCustomerContainsValue(value);
    }

    @Override
    public double customerIdSearchMonth(int month) {
        List<Integer> customerIdList = customerImpl.customerIdSearchMonth(month);
        BillServiceImpl billService = new BillServiceImpl();
        return billService.billsTotalPriceMonth(customerIdList);
    }

    @Override
    public List<Customer> customersListById(List<Integer> integerList) {
        return customerImpl.customersListById(integerList);
    }
}
