<%@ page import="com.java.hotel.Customer" %>
<%@ page import="com.java.hotel.CustomerDAO" %>
<%@ page import="com.java.hotel.CustomerDAOImpl" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Customer</title>
</head>
<body>
    <form method="post" action="AddCustomer.jsp">
        <center>
            Customer Name:
            <input type="text" name="customerName" /> <br/><br/>
            Check-In Date:
            <input type="date" name="checkInDate" /> <br/><br/>
            Check-Out Date:
            <input type="date" name="checkOutDate" /> <br/><br/>
            Room Number:
            <input type="number" name="roomNumber" /> <br/><br/>
            <input type="submit" value="Add Customer" />
        </center>
    </form>
    <%
        if (request.getParameter("customerName") != null && request.getParameter("checkInDate") != null && request.getParameter("checkOutDate") != null && request.getParameter("roomNumber") != null) {
            CustomerDAO dao = new CustomerDAOImpl();
            Customer customer = new Customer();
            customer.setCustomerName(request.getParameter("customerName"));
            customer.setCheckInDate(java.sql.Date.valueOf(request.getParameter("checkInDate")));
            customer.setCheckOutDate(java.sql.Date.valueOf(request.getParameter("checkOutDate")));
            customer.setRoomNumber(Integer.parseInt(request.getParameter("roomNumber")));
            dao.addCustomer(customer);
    %>
            <jsp:forward page="ShowCustomer.jsp"/>
    <%
        }
    %>
</body>
</html>
