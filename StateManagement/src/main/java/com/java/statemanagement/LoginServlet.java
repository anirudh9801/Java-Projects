package com.java.statemanagement;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		PrintWriter out = response.getWriter();
		String user = request.getParameter("userName");
		String Pwd = request.getParameter("password");
		String firstName="", lastName="";
		
		if(user.equals("Jitu") && Pwd.equals("Jitu")) {
			firstName="Jitendra";
			lastName="Sahoo";
		}
		if(user.equals("Sonali") && Pwd.equals("Sonali")) {
			firstName="Sonali";
			lastName="Sahu";
		}
		if(user.equals("ganu") && Pwd.equals("ganu")) {
			firstName="Ganesh";
			lastName="Mirda";
		}
		out.println("<a href='WelcomeServlet?firstName="+firstName+"&lastName="+lastName+"'>Welcome</a>");
		
	}

}
