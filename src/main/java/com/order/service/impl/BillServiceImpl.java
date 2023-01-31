package com.order.service.impl;

import com.order.dao.impl.BIllImpl;
import com.order.model.Bill;
import com.order.model.Customer;
import com.order.model.Sector;
import com.order.model.enumeration.MONTH;
import com.order.service.BillService;

import java.util.List;

public class BillServiceImpl implements BillService {

    BIllImpl billImpl = new BIllImpl();
    @Override
    public String saveBill(Bill bill) {
        return billImpl.saveBill(bill);
    }

    @Override
    public List<Bill> allBills() {
        return billImpl.allBills();
    }

    @Override
    public List<Bill> allBillsBiggerThanValue(int value) {
        return billImpl.allBillsBiggerThanValue(value);
    }

    @Override
    public double allBillsAverageBiggerThanValue(int value) {
        return billImpl.allBillsAverageBiggerThanValue(value);
    }

    @Override
    public double billsTotalPriceMonth(List<Integer> customerId) {
        return billImpl.billsTotalPriceMonth(customerId);
    }

    @Override
    public List<Customer> allBillsTotalPriceSmallerThan(int value) {
        List<Integer> integerList = billImpl.allBillsTotalPriceSmallerThan(value);
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        return customerService.customersListById(integerList);
    }

    @Override
    public List<Sector> billsAveragePriceSmallerThanAndMonth(int value, int month) {
        List<Integer> integers = billImpl.billsAveragePriceSmallerThanAndMonth(500, MONTH.JUNE.ordinal());
        SectorServiceImpl sectorService = new SectorServiceImpl();
        return sectorService.allSectorById(integers);
    }
}
