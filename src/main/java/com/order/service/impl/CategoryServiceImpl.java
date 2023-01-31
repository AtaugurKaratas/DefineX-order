package com.order.service.impl;

import com.order.dao.impl.CategoryImpl;
import com.order.model.Category;
import com.order.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
    @Override
    public String saveCategory(Category category) {
        CategoryImpl categoryImpl = new CategoryImpl();
        return categoryImpl.saveCategory(category);
    }
}
