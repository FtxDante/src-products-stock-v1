package com.itenorio.products_stock_v1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itenorio.products_stock_v1.entity.User;
import com.itenorio.products_stock_v1.enums.Role;
import com.itenorio.products_stock_v1.repository.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public void addNewUser(String name, String email, String password) {
    User user = new User();

    user.setName(name);
    user.setEmail(email);
    user.setPassword(password);
    user.setRole(Role.USER);

    userRepository.save(user);
  }

  public Iterable<User> getAllUsers() {
    return userRepository.findAll();
  }
}
