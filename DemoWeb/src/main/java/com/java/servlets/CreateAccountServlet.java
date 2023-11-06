package com.java.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateAccountServlet
 */
public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccountServlet() {
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
		Bank bank = new Bank();
//		bank.setAccountNo(Integer.parseInt(request.getParameter("accountNo")));
		bank.setFirstName(request.getParameter("firstName"));
		bank.setLastName(request.getParameter("lastName"));
		bank.setCity(request.getParameter("city"));
		bank.setState(request.getParameter("state"));
		bank.setAmount(Integer.parseInt(request.getParameter("amount")));
		bank.setCheqFacil(request.getParameter("chequeFacil"));
		bank.setAccountType(request.getParameter("accountType"));
		PrintWriter out = response.getWriter();
		BankDAO dao = new BankDAOImpl();
		
	    try {
	        String result = dao.createAccountDao(bank);
	        if (result != null) {
	           
	            out.println("Bank account created successfully.");
	        } else {
	            
	            out.println("Failed to create a bank account.");
	        }
	    } catch (ClassNotFoundException | SQLException e) {
	      
	        e.printStackTrace();
	        out.println("An error occurred while creating the bank account: " + e.getMessage());
	    }
	}
}




