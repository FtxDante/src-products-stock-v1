package com.itenorio.products_stock_v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itenorio.products_stock_v1.entity.User;
import com.itenorio.products_stock_v1.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {

  @Autowired
  public UserService userService;

  @PostMapping(path = "/add") // Map ONLY POST Requests
  public @ResponseBody String addNewUser(
      @RequestParam String name,
      @RequestParam String email,
      @RequestParam String password) {

    this.userService.addNewUser(name, email, password);
    return "Saved";
  }

  @GetMapping(path = "/all")
  public @ResponseBody Iterable<User> getAllUsers() {
    return this.userService.getAllUsers();
  }
}
