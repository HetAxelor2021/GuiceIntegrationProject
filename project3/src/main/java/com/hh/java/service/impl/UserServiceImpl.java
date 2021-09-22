package com.hh.java.service.impl;

import javax.persistence.EntityManager;

import com.google.inject.Inject;
import com.hh.java.model.User;
import com.hh.java.service.UserService;

public class UserServiceImpl implements UserService{
	
	@Inject
	private EntityManager entityManager;
	
		 
	
	
	@Override
	public String authenticate(String userName, String password) {
		
		System.out.println("UserServiceImpl : authenticate");
		String status=null;
		String query = "FROM user_tb WHERE  userName=:userName and password=:password";
		User user = (User)entityManager.createQuery(query).setParameter("userName",userName).setParameter("password",password).getSingleResult();
		if(user != null) {
			status = "Valid";
			
		}else {
			status = "InValid";
		}
		return status;
	}
}
