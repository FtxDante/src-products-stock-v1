package com.itenorio.products_stock_v1.modules.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.itenorio.products_stock_v1.modules.users.entity.User;
import com.itenorio.products_stock_v1.modules.users.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {

  @Autowired
  public UserService userService;

  @PostMapping(path = "/user")
  public @ResponseBody String addNewUser(
      @RequestParam String name,
      @RequestParam String email,
      @RequestParam String password) throws InternalServerError {

    this.userService.addNewUser(name, email, password);
    return "Saved";
  }

  @GetMapping(path = "/users")
  public @ResponseBody Iterable<User> getAllUsers() throws InternalServerError {
    return this.userService.getAllUsers();
  }

  @GetMapping(path = "/user/{id}")
  public User findUserByID(@PathVariable("id") Integer id) throws NotFoundException {
    return this.userService.getUserByID(id);
  }

  @PutMapping(path = "/user/{id}")
  public @ResponseBody User updateUser(@RequestBody User user, @PathVariable("id") Integer id) throws InternalServerError, NotFoundException {
    return this.userService.updateUser(user, id);
  }

  @DeleteMapping(path = "/user/{id}")
  public String deleteUser(@PathVariable("id") Integer id) throws NotFoundException {
    this.userService.deleteUser(id);
    return "Deleted Successfully";
  }
}
