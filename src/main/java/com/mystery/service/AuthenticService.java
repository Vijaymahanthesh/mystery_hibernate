package com.mystery.service;

import com.mystery.model.User;

public interface AuthenticService {

	User signin(User user);

	User forgotPassword(User user);

	User resetPassword(User user);

}
