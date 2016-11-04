package com.ironpeter.springdemo.service;

import com.ironpeter.springdemo.model.UserBean;

public interface UserService {
	void addUser(UserBean userbean);

	void deleteUser(int userId);

	void updateUser(UserBean userbean);

	UserBean getUser(int userId);

	UserBean getUser(String userName);

}
