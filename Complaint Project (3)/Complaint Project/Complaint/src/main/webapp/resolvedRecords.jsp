<%@page import="com.java.comp.Resolve"%>
<%@page import="java.util.List"%>
<%@page import="com.java.comp.ResolveComplaint"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
 <h1>Resolved Complaints</h1>
    <table border="1">
        <tr>
            <th>Resolve ID</th>
            <th>Complaint ID</th>
            <th>Complaint Date</th>
            <th>Resolve Date</th>
            <th>Resolved By</th>
            <th>Comments</th>
            <th>TAT (Hours)</th>
        </tr>
        <%
            ResolveComplaint resolveDataDAO = new ResolveComplaint();
            List<Resolve> resolvedComplaints = resolveDataDAO.ResolvedRecords();
            
            for (Resolve complaint : resolvedComplaints) {
                long tat = complaint.getTat();
                String rowColor = (tat >= 7 && tat < 10) ? "pink" : (tat >= 10) ? "red" : "white";
        %>
                <tr style="background-color:<%= rowColor %>;">
                    <td><%= complaint.getResolveID() %></td>
                    <td><%= complaint.getComplaintID() %></td>
                    <td><%= complaint.getComplaintDate() %></td>
                    <td><%= complaint.getResolveDate() %></td>
                    <td><%= complaint.getResolvedBy() %></td>
                    <td><%= complaint.getComments() %></td>
                    <td><%= complaint.getTat() %></td>
                </tr>
        <%
            }
        %>
        <a href="Main.jsp">Back to Main Menu</a>
    </table>
</body>
</html>

