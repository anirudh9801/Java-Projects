<%@page import="com.java.comp.Complaint"%>
<%@page import="java.util.List"%>
<%@page import="com.java.comp.ComplaintDAOImpl"%>
<%@page import="com.java.comp.ComplaintDAO"%>
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
ComplaintDAO dao=new ComplaintDAOImpl();
List<Complaint> complist=dao.showComplaintDao();
%>

<table border="3" align="center">
<tr>
<th>Complaint ID</th>
<th>Complaint Type</th>
<th>CDescription</th>
<th>ComplaintDate</th>
<th>Severity</th>
<th>Status</th>
</tr>

<%
for(Complaint comp: complist){
	%>
	<tr>
				<td><%=comp.getComplaintID() %> </td>
				<td><%=comp.getComplaintType() %> </td>
				<td><%=comp.getCDescription() %> </td>
				<td><%=comp.getComplaintDate() %> </td>
				<td><%=comp.getSeverity() %> </td>
				<td><%=comp.getStatus() %> </td>
				<%-- <td><a href=UpdateAgent.jsp?agentId=<%=agent.getAgentId() %> >Update</a></td>
				<td><a href=DeleteAgent.jsp?agentId=<%=agent.getAgentId() %> >Delete</a></td> --%>
			</tr>
		<%
			}
		%>
		
</table>
<a href="AddComp.jsp">Add Complaint</a><br/><br/><a href="Main.jsp">Back to Main Menu</a>
</body>
</html>