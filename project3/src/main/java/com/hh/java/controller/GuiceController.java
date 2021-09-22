package com.hh.java.controller;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

//import com.google.common.net.MediaType;
import com.google.inject.Inject;
import com.hh.java.service.GuiceService;
import com.hh.java.service.UserService;


@Path("/guice")
public class GuiceController {
	
	
	
	@Inject
	private GuiceService guiceService;
	
	
	@Inject
	private UserService userService;
	
	@POST
	@Path("/authbyjson")
	@Produces(MediaType.TEXT_PLAIN)
	public String authenticate(JSONObject jsonObject) throws JSONException{
		return userService.authenticate(jsonObject.getString("userName"), jsonObject.getString("password"));
	}
	
	
	
	@GET
	@Path("/authbyquery")
	@Produces(MediaType.TEXT_PLAIN)
	public String authenticate(@QueryParam("userName") String userName, @QueryParam("password") String password) {
		
		return userService.authenticate(userName, password );
	}
	
	
	@GET
	@Path("/authbyuri")
	@Produces(MediaType.TEXT_PLAIN)
	public String authenticate(@Context UriInfo uriInfo) {
		return userService.authenticate(uriInfo.getQueryParameters().getFirst("userName"), 
				uriInfo.getQueryParameters().getFirst("password"));
		
	}
	
	
	
	@GET
	@Path("/sayhello")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayhello() {
		return guiceService.sayHello();
	}
}
