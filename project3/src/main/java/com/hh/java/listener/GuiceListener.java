package com.hh.java.listener;

import javax.servlet.annotation.WebListener;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.hh.java.module.GuiceModule;
import com.hh.java.servlet.GuiceServlet;


@WebListener
public class GuiceListener extends GuiceServletContextListener{
	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new GuiceModule() {
			@Override
			protected void configureServlets() {
				serve("/").with(GuiceServlet.class);
				
				 	
			}
		});
	}
}
