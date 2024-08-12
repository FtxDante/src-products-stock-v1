package com.itenorio.products_stock_v1.repository;

import org.springframework.data.repository.CrudRepository;

import com.itenorio.products_stock_v1.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
