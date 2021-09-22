package com.hh.java.service;

import com.google.inject.ImplementedBy;
import com.hh.java.service.impl.GuiceServiceImpl;

@ImplementedBy 	(GuiceServiceImpl.class)
public interface GuiceService {
	String sayHello();
}	
