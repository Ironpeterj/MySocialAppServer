package com.ironpeter.springdemo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ironpeter.springdemo.dao.UserDao;
import com.ironpeter.springdemo.model.UserBean;

public class TestSql {

	public static void main(String[] args) {

		ApplicationContext ctx = null;
		ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		UserDao ud = (UserDao) ctx.getBean("userDao");
		UserBean ub = new UserBean();
		ub.setUserId(1);
		ub.setUserName("jim");
		ub.setUserPwd("123456");
		ud.addUser(ub);
		ub.setUserId(2);
		ub.setUserName("lily");
		ub.setUserPwd("123456");
		ud.addUser(ub);

	}

}
