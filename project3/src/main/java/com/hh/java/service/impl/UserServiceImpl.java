package com.hh.java.service.impl;

import com.hh.java.service.UserService;

public class UserServiceImpl implements UserService{
	public String authenticate(String userName, String password) {
		String status="";
		if(userName.equals("test") && password.equals("test")) {
			status = "Valid";
			
		}else {
			status = "InValid";
		}
		return status;
	}
}
