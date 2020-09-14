package com.mystery.dao;

import java.util.List;

import com.mystery.model.User;

public interface UserDao {
	
  void createUser(User user);

  User checkEmailExistOrNot(User user, String email);

  List<User> getUserList();

  User getUserDetailsById(int userId);

  User deleteUserById(int userId);

  List<User> getInactiveUserList();

  User restoreUserById(int userId);
}
