package com.itenorio.products_stock_v1.modules.users.service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.itenorio.products_stock_v1.modules.users.entity.User;
import com.itenorio.products_stock_v1.modules.users.enums.Role;
import com.itenorio.products_stock_v1.modules.users.repository.UserRepository;

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

    this.userRepository.save(user);
  }

  public Iterable<User> getAllUsers() {
    return this.userRepository.findAll();
  }

  public User updateUser(User user, Integer id) throws NotFoundException {
    Optional<User> optionalUser = this.userRepository.findById(id);
    if (!optionalUser.isPresent()) {
      throw new NotFoundException();
    }

    User userFound = optionalUser.get();
    if (Objects.nonNull(user.getName()))
      userFound.setName(user.getName());

    if (Objects.nonNull(user.getEmail()))
      userFound.setEmail(user.getEmail());

    if (Objects.nonNull(user.getPassword()))
      userFound.setPassword(user.getPassword());

    if (Objects.nonNull(user.getRole()))
      userFound.setRole(user.getRole());

    return userRepository.save(userFound);

  }

  public void deleteUser(Integer id) throws NotFoundException {

    Optional<User> optionalUser = this.userRepository.findById(id);
    if (!optionalUser.isPresent()) {
      throw new NotFoundException();
    }

    this.userRepository.deleteById(id);
  }
}
