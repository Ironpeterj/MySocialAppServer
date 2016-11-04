package com.ironpeter.springdemo.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ironpeter.springdemo.model.UserBean;

@Repository
@Transactional
public interface UserDao {

	public UserBean getUser(UserBean user);

	public void addUser(UserBean user);

	public void updateUser(UserBean user);

	public void deleteUser(int userId);

}
