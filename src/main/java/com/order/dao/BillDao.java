package com.order.dao;

import com.order.model.Bill;

import java.util.List;

public interface BillDao {
    String saveBill(Bill bill);
    List<Bill> allBills();
    List<Bill> allBillsBiggerThanValue(int value);
    double allBillsAverageBiggerThanValue(int value);
    double billsTotalPriceMonth(List<Integer> customerId);
    List<Integer> allBillsTotalPriceSmallerThan(int value);
    List<Integer> billsAveragePriceSmallerThanAndMonth(int value, int month);
}
