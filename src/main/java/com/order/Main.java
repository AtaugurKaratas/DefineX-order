package com.order;

import com.order.model.Customer;
import com.order.model.enumeration.MONTH;
import com.order.service.impl.BillServiceImpl;
import com.order.service.impl.CustomerServiceImpl;

public class Main {
    public static void main(String[] args) {

        CustomerServiceImpl customerService = new CustomerServiceImpl();
        BillServiceImpl billService = new BillServiceImpl();

        //List all customers
        System.out.println(customerService.allCustomers());

        //Able to create new customers
        Customer customer = new Customer("Ataugur", "Karatas");
        System.out.println(customerService.saveCustomer(customer));

        //List customers with the letter 'C' in them
        System.out.println(customerService.allCustomerContainsValue("C"));

        //List the total amount of invoices for customers who signed up in June
        System.out.println(customerService.customerIdSearchMonth(MONTH.JUNE.ordinal()));

        //List all invoices in the system
        System.out.println(billService.allBills());

        //List invoices over 1500TL in the system
        System.out.println(billService.allBillsBiggerThanValue(1500));

        //Calculate the average of invoices over 1500TL in the system
        System.out.println(billService.allBillsAverageBiggerThanValue(1500));

        //List the names of customers with invoices under 500TL in the system
        System.out.println(billService.allBillsTotalPriceSmallerThan(500));

        //Lists the companies in which the average invoices for the month of June are below 750.
        System.out.println(billService.billsAveragePriceSmallerThanAndMonth(750, MONTH.JUNE.ordinal()));

    }
}