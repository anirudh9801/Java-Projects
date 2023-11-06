<%@page import="com.java.hotel.Customer"%>
<%@page import="com.java.hotel.CustomerDAO"%>
<%@page import="com.java.hotel.CustomerDAOImpl"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Customer</title>
</head>
<body>
<%
    int customerID = Integer.parseInt(request.getParameter("customerID"));
    CustomerDAO dao = new CustomerDAOImpl();
    Customer customer = dao.searchCustomer(customerID);
%>
<form method="post" action="UpdateCustomer.jsp">
    <center>
        Customer ID:
        <input type="number" name="customerID" readonly="readonly" value="<%=customer.getCustomerID() %>" /> <br/><br/>
        Customer Name:
        <input type="text" name="customerName" value="<%=customer.getCustomerName() %>" /> <br/><br/>
        Check-In Date:
        <input type="text" name="checkInDate" value="<%=new SimpleDateFormat("yyyy-MM-dd").format(customer.getCheckInDate()) %>" /> <br/><br/>
        Check-Out Date:
        <input type="text" name="checkOutDate" value="<%=new SimpleDateFormat("yyyy-MM-dd").format(customer.getCheckOutDate()) %>" /> <br/><br/>
        Room Number:
        <input type="number" name="roomNumber"  value="<%=customer.getRoomNumber() %>" /> <br/><br/>
        
        <input type="submit" value="Update Customer" />
    </center>
</form>
<%
if(request.getParameter("customerID")!=null && request.getParameter("customerName")!=null){
    Customer customerUpdated = new Customer();
    customerUpdated.setCustomerID(Integer.parseInt(request.getParameter("customerID")));
    customerUpdated.setCustomerName(request.getParameter("customerName"));
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    customerUpdated.setCheckInDate(new java.sql.Date(sdf.parse(request.getParameter("checkInDate")).getTime()));
    customerUpdated.setCheckOutDate(new java.sql.Date(sdf.parse(request.getParameter("checkOutDate")).getTime()));
    customerUpdated.setRoomNumber(Integer.parseInt(request.getParameter("roomNumber")));
    dao.updateCustomer(customerUpdated);
 
%>
    <jsp:forward page="ShowCustomer.jsp"/>
<%
}
%>
</body>
</html>
