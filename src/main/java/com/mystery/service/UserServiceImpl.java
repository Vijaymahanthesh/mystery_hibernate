package com.mystery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mystery.dao.UserDao;
import com.mystery.model.User;

@Service
public class UserServiceImpl implements UserService {
     
	@Autowired
	private  UserDao userDao;
	
	@Override
	public void createUser(User user) {
		userDao.createUser(user);
	}

	@Override
	public User checkEmailExistOrNot(User user, String email) {
		return userDao.checkEmailExistOrNot(user,email);
	}

	@Override
	public List<User> getUserList() {
		return userDao.getUserList();
	}

	@Override
	public User getUserDetailsById(int userId) {
		return userDao.getUserDetailsById(userId);
	}

	@Override
	public User deleteUserById(int userId) {
		return userDao.deleteUserById(userId);
		
	}

	@Override
	public List<User> getInactiveUserList() {
		return userDao.getInactiveUserList();
	}

	@Override
	public User restoreUserById(int userId) {
		return userDao.restoreUserById(userId);
	}
	

}
