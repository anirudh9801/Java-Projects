<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <form method="get" action="Demo.jsp">
    <center>
    Name:
      <input type="text" name="sname"/><br/><br/>
      <input type="submit" value="show"/>
    </center>
    </form>
    <%--
    Java code
     --%>
     <%
     if(request.getParameter("sname")!=null){
    	 String sname = request.getParameter("sname");
    	 out.println("Student name is " +sname);
     }
     %>

</body>
</html>