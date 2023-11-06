<%@page import="java.sql.Timestamp"%>
<%@page import="com.java.comp.Resolve"%>
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
<form method="get" action="AddResolve.jsp">
	<center>
		
		Complaint ID :
		<input type="text" name="complaintID"/><br/><br/>
		ResolveDate :
		<input type="text" name="resolveDate" placeholder="yyyy-MM-dd hh:mm:ss" />
		ResolvedBy :
		<input type="text" name="resolvedBy" />
		Comments :
		<input type="text" name="comments" />
		<br/><br/>
		<input type="submit" value="Add Resolve" />
	</center>
</form>
<%
if(request.getParameter("complaintID")!=null){
	ResolveComplaint dao = new ResolveComplaint();
	Resolve resolve = new Resolve();
	 String resolveDateStr = request.getParameter("resolveDate");
	    
	Timestamp resolveDate = Timestamp.valueOf(resolveDateStr);
	resolve.setComplaintID(request.getParameter("complaintID"));
	resolve.setResolveDate(resolveDate);
	resolve.setResolvedBy(request.getParameter("resolvedBy"));
	resolve.setComments(request.getParameter("comments"));
	dao.addResolve(resolve);
%>
	<jsp:forward page="Main.jsp"/>
	<%
}
%>
</body>
</html>