package com.mystery.service;

import java.util.List;

import com.mystery.model.User;

public interface UserService {

	void createUser(User user);
	
    List<User> getUserList();

	User getUserDetailsById(int userId);

	User deleteUserById(int userId);

	List<User> getInactiveUserList();

	User restoreUserById(int userId);
	
	User checkEmailExistOrNot(User user, String email);

}
