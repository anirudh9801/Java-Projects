<%@page import="com.java.comp.Complaint"%>
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
 <form method="get" action="AddComp.jsp">
	<center>
		 Complaint Type :
		<input type="text" name="complaintType" /> <br/><br/>
		CDescription :
		<input type="text" name="CDescription"/><br/><br/>
		Severity :
		<input type="text" name="severity" />
		<br/><br/>
		<input type="submit" value="Add complaint" />
	</center>
</form>
<%
if(request.getParameter("complaintType")!=null){
	ComplaintDAO dao = new ComplaintDAOImpl();
	Complaint comp = new Complaint();
	comp.setComplaintType(request.getParameter("complaintType"));
	comp.setCDescription(request.getParameter("CDescription"));
	comp.setSeverity(request.getParameter("severity"));
	dao.addComplaintDao(comp);
%>
	<jsp:forward page="ShowComp.jsp"/>
	<%
}
%>
<a href="Main.jsp">Back to Main Menu</a>
</body>
</html>