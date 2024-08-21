package com.itenorio.products_stock_v1.modules.products.repository;

import org.springframework.data.repository.CrudRepository;

import com.itenorio.products_stock_v1.modules.products.schema.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
