package com.ironpeter.springdemo.util;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

public class PostRequestHandler {

	public static Object handleLoginRequest(HttpServletRequest request) {

		JSONObject result = new JSONObject();
		try {
			StringBuffer buffer = reedInputStream(request);
			String postData = buffer.toString();
			System.out.println("request infor: " + postData);
			result.put("status", 200);
			result.put("infor", "loginsuccess");
		} catch (IOException e) {
			System.out.println(e.toString());
			result.put("status", 201);
			result.put("infor", "server read login infor error");
		}

		return result;
	}

	public static Object handleRegisterRequest(HttpServletRequest request) throws IOException {

		JSONObject result = new JSONObject();
		String postData = "";
		StringBuffer buffer = reedInputStream(request);
		postData = buffer.toString();
		return postData;
	}

	private static StringBuffer reedInputStream(HttpServletRequest request) throws IOException {
		BufferedReader bufferReader;
		bufferReader = request.getReader();
		StringBuffer buffer = new StringBuffer();
		String line = " ";
		while ((line = bufferReader.readLine()) != null) {
			buffer.append(line);
		}
		return buffer;
	}

}
