<%@page import="java.util.List"%>
<%@page import="com.java.comp.ComplaintDAOImpl"%>
<%@page import="com.java.comp.ComplaintDAO"%>
<%@page import="com.java.comp.Complaint"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

%>
 <h1>Search Results</h1>
    <%
        // Retrieve the employee ID from the form
        String complaintID = request.getParameter("complaintID");

        // Use the EmployeeDAO to get the employee details
        ComplaintDAO dao = new ComplaintDAOImpl();
        Complaint comp = dao.searchComplaint(complaintID);

        if (comp != null) {
    %>
    <table border="1">
        <tr>
            <th>Complaint ID</th>
			<th>Complaint Type</th>
			<th>CDescription</th>
			<th>ComplaintDate</th>
			<th>Severity</th>
			<th>Status</th>
            <!-- Add other employee attributes here -->
        </tr>
        <tr>
            <td><%= comp.getComplaintID() %></td>
            <td><%= comp.getComplaintType() %></td>
            <td><%= comp.getCDescription() %></td>
            <td><%= comp.getComplaintDate() %></td>
            <td><%= comp.getSeverity() %></td>
            <td><%= comp.getStatus() %></td>
            <!-- Display other employee attributes here -->
        </tr>
    </table>
    <%
        } else {
    %>
    <p> ComplaintID not found with the given ID.</p>
    <%
        }
    %>
    <a href="SearchComp.jsp">Back to Search</a>
</body>
</html>




   

