package com.java.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

/**
 * Servlet implementation class SearchAccountServlet
 */
public class SearchAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		 int accountNo = Integer.parseInt(request.getParameter("accountNo"));
		    BankDAO dao = new BankDAOImpl();
		    Bank account = null;

		    try {
		        account = dao.searchAccountDao(accountNo);

		        if (account != null) {
		            PrintWriter out = response.getWriter();
		            out.println("Account Number: " + account.getAccountNo());
		            out.println("First Name: " + account.getFirstName());
		            out.println("Last Name: " + account.getLastName());
		            out.println("City: " + account.getCity());
		            out.println("State: " + account.getState());
		            out.println("Amount: " + account.getAmount());
		            out.println("Cheque Facility: " + account.getCheqFacil());
		            out.println("Account Type: " + account.getAccountType());
		        } else {
		          
		            PrintWriter out = response.getWriter();
		            out.println("*** Record Not Found ***");
		        }
		    } catch (ClassNotFoundException | SQLException e) {
		   
		        e.printStackTrace();
		        response.sendRedirect("error.html"); 
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(request, response);
}
}
