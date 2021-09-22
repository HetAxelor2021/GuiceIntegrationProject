package com.hh.java.listener;

import javax.servlet.annotation.WebListener;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.hh.java.module.GuiceModule;
import com.hh.java.servlet.ActionServlet;
import com.hh.java.servlet.GuiceServlet;
import com.hh.java.servlet.LoginServlet;


@WebListener
public class GuiceListener extends GuiceServletContextListener{
	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new GuiceModule() {
			@Override
			protected void configureServlets() {
				serve("/guice").with(GuiceServlet.class);
				serve("/login").with(LoginServlet.class);
				serve("/authenticate").with(ActionServlet.class); 	
			}
		});
	}
}
