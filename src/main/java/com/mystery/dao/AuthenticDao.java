package com.mystery.dao;

import com.mystery.model.User;

public interface AuthenticDao {

	User signin(User user);

	User forgotPassword(User user);

	User updatePassword(User user);

}
