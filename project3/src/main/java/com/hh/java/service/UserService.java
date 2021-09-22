package com.hh.java.service;

import com.google.inject.ImplementedBy;
import com.hh.java.service.impl.UserServiceImpl;

@ImplementedBy(UserServiceImpl.class)
public interface UserService {
	String authenticate(String username, String password);
	
}
