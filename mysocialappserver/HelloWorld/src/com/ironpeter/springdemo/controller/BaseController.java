package com.ironpeter.springdemo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ironpeter.springdemo.model.UserBean;
import com.ironpeter.springdemo.service.UserService;
import com.ironpeter.springdemo.util.PostRequestHandler;
import com.ironpeter.springdemo.util.UTF8Tools;

import net.sf.json.JSONObject;

@Controller
public class BaseController {

	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("login")
	public ResponseEntity<String> login(HttpServletRequest request, HttpServletResponse response) {
		JSONObject o = (JSONObject) PostRequestHandler.handleLoginRequest(request);
		return new UTF8Tools().transferUTF8(o.toString());
	}

	@RequestMapping("register")
	public ResponseEntity<String> register(HttpServletRequest request, HttpServletResponse response) {
		String postData;
		JSONObject result = new JSONObject();
		try {
			postData = PostRequestHandler.handleRegisterRequest(request).toString();
			if (postData.isEmpty()) {
				result.put("status", 202);
				result.put("infor", "register infor can not be empty");
			} else {
				System.out.println("register request infor: " + postData);
				JSONObject o = JSONObject.fromObject(postData);
				UserBean ub = new UserBean();
				ub.setUserName(o.getString("username"));
				ub.setUserPwd(o.getString("pwd"));
				userService.addUser(ub);
				result.put("status", 200);
				result.put("infor", "register success");

			}
		} catch (IOException e) {
			result.put("status", 201);
			result.put("infor", "register json data error");
		}
		return new UTF8Tools().transferUTF8(result.toString());
	}

}
