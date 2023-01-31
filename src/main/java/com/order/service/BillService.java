package com.order.service;

import com.order.model.Bill;
import com.order.model.Customer;
import com.order.model.Sector;

import java.util.List;

public interface BillService {
    String saveBill(Bill bill);

    List<Bill> allBills();

    List<Bill> allBillsBiggerThanValue(int value);

    double allBillsAverageBiggerThanValue(int value);

    double billsTotalPriceMonth(List<Integer> customerId);

    List<Customer> allBillsTotalPriceSmallerThan(int value);

    List<Sector> billsAveragePriceSmallerThanAndMonth(int value, int month);
}
