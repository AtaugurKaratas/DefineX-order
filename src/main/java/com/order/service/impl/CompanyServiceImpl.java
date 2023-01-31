package com.order.service.impl;

import com.order.dao.impl.CompanyImpl;
import com.order.model.Company;
import com.order.service.CompanyService;

public class CompanyServiceImpl implements CompanyService {
    @Override
    public String saveCompany(Company company) {
        CompanyImpl companyImpl = new CompanyImpl();
        return companyImpl.saveCompany(company);
    }
}
