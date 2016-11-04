package com.ironpeter.springdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ironpeter.springdemo.dao.UserDao;
import com.ironpeter.springdemo.model.UserBean;
import com.ironpeter.springdemo.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void addUser(UserBean userbean) {
		userDao.addUser(userbean);
	}

	@Override
	public void deleteUser(int userId) {

	}

	@Override
	public void updateUser(UserBean userbean) {

	}

	@Override
	public UserBean getUser(int userId) {
		return null;
	}

	@Override
	public UserBean getUser(String userName) {
		return null;
	}

}
