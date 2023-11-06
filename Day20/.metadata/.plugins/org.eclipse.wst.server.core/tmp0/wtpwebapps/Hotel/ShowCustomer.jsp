<%@page import="com.java.hotel.Customer"%>
<%@page import="java.util.List"%>
<%@page import="com.java.hotel.CustomerDAOImpl"%>
<%@page import="com.java.hotel.CustomerDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List</title>
</head>
<body>
    <%
        CustomerDAO dao = new CustomerDAOImpl();
        List<Customer> customerList = dao.showCustomer();
    %>
    <table border="3" align="center">
        <tr>
            <th>Customer ID</th>
            <th>Customer Name</th>
            <th>Check-In Date</th>
            <th>Check-Out Date</th>
            <th>Room Number</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        <%
            for (Customer customer : customerList) {
        %>
            <tr>
                <td><%= customer.getCustomerID() %></td>
                <td><%= customer.getCustomerName() %></td>
                <td><%= customer.getCheckInDate() %></td>
                <td><%= customer.getCheckOutDate() %></td>
                <td><%= customer.getRoomNumber() %></td>
                <td>
                    <a href="UpdateCustomer.jsp?customerID=<%= customer.getCustomerID() %>">Update</a>
                </td>
                <td>
                    <a href="DeleteCustomer.jsp?customerID=<%= customer.getCustomerID() %>">Delete</a>
                </td>
            </tr>
        <%
            }
        %>
    </table>
    <hr />
    <a href="AddCustomer.jsp">Add Customer</a>
</body>
</html>
