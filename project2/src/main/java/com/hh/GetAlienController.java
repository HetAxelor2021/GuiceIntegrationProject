package com.hh;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hh.web.dao.AlienDao;
import com.hh.web.model.Alien;

/**
 * Servlet implementation class GetAlienController
 */
@WebServlet("/getAlien")
public class GetAlienController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int aid = Integer.parseInt(request.getParameter("aid"));
		AlienDao dao = new AlienDao();
		
		@SuppressWarnings("unused")
		Alien a1 = dao.getAlien(aid);
		
		HttpSession session = request.getSession();
		session.setAttribute("alien", a1);
		
		response.sendRedirect("showAlien.jsp");
		
		
//		request.setAttribute("alien",a1);
//		
//		RequestDispatcher rd = request.getRequestDispatcher("showAlien.jsp");
//		rd.forward(request, response);
//		
		
		
	}

	

}
 