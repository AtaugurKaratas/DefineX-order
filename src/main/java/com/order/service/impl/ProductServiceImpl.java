package com.order.service.impl;

import com.order.dao.impl.ProductImpl;
import com.order.model.Product;
import com.order.service.ProductService;

public class ProductServiceImpl implements ProductService {
    @Override
    public String saveProduct(Product product) {
        ProductImpl productImpl = new ProductImpl();
        return productImpl.saveProduct(product);
    }
}
