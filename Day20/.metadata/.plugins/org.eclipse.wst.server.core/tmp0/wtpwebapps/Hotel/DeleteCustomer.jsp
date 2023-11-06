<%@page import="com.java.hotel.CustomerDAOImpl"%>
<%@page import="com.java.hotel.CustomerDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Customer</title>
</head>
<body>
    <%
    int customerID = Integer.parseInt(request.getParameter("customerID"));
    CustomerDAO dao = new CustomerDAOImpl();
    dao.deleteCustomer(customerID);
    %>
    <jsp:forward page="ShowCustomer.jsp"/>
</body>
</html>
