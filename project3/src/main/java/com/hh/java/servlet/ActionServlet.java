package com.hh.java.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.hh.java.service.UserService;

@Singleton
public class ActionServlet extends HttpServlet{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private UserService userService;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String username= request.getParameter("username");
		String password  = request.getParameter("password");
		response.getWriter().println("user name :"+username+ " and Password : "+ password +" status : "+userService.authenticate(username,password));
	}
}
