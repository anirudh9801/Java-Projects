package com.java.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.ws.rs.core.Request;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   PrintWriter out= response.getWriter();
	   String user, pwd;
	   user = request.getParameter("userName");
	   pwd = request.getParameter("password");
	   
	   if(user.equals("Infinite")&& pwd.equals("Infinite")){
		   RequestDispatcher disp = request.getRequestDispatcher("Menu.html");
		   disp.forward(request, response);
		   out.println("Correct credentialsss......");
	   }else {
		   RequestDispatcher disp = request.getRequestDispatcher("Login.html");
		   disp.include(request, response);
		   out.println("Invalid credentialsss......");
	   }
	   		
	}

}
