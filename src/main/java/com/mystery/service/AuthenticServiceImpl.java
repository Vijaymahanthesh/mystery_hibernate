package com.mystery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mystery.dao.AuthenticDao;
import com.mystery.model.User;

@Service
public class AuthenticServiceImpl implements AuthenticService{
	
	@Autowired
	private AuthenticDao authenticDao;

	@Override
	public User signin(User user) {
		return authenticDao.signin(user);

	}

	@Override
	public User forgotPassword(User user) {
		return authenticDao.forgotPassword(user);
	}

	@Override
	public User resetPassword(User user) {
	    return authenticDao.updatePassword(user);
	}

}
