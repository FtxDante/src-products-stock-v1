package com.itenorio.products_stock_v1.modules.users.repository;

import org.springframework.data.repository.CrudRepository;

import com.itenorio.products_stock_v1.modules.users.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
