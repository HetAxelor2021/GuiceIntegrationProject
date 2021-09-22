package com.hh.java.listener;

import javax.servlet.annotation.WebListener;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.GuiceServletContextListener;
import com.hh.java.controller.GuiceController;
import com.hh.java.module.GuiceModule;
import com.hh.java.servlet.ActionServlet;
import com.hh.java.servlet.GuiceServlet;
import com.hh.java.servlet.LoginServlet;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;


@WebListener
public class GuiceListener extends GuiceServletContextListener{
	@Override
	protected Injector getInjector() {
		
		Injector injector = Guice.createInjector(new JerseyServletModule() {
			@Override
			protected void configureServlets() {
				bind(GuiceController.class);
				serve("/rest/*").with(GuiceContainer.class);
				
//				serve("/guice").with(GuiceServlet.class);
//				serve("/login").with(LoginServlet.class);
//				serve("/authenticate").with(ActionServlet.class); 	
			}
			
		}, new JpaPersistModule("db_manager"));
		
		injector.getInstance(JpaInitializer.class);
		return injector;
		
		
//		return Guice.createInjector(new GuiceModule() {
		
	}
}

class JpaInitializer {
	@Inject
	public JpaInitializer(PersistService persistService) {
		persistService.start();
	}
}
