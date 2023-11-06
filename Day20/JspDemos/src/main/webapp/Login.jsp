<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <form method="get" action="Login.jsp">
    <center>
    User Name:
      <input type="text"  name="userName"/><br/><br/>
      Password:
      <input type="text" name="passWord"/><br/><br/>
     <input type="submit" value="Login"/>
     
      
    </center>
    </form>
    <%
    if(request.getParameter("userName")!=null && request.getParameter("passWord")!=null){
    	String userName = request.getParameter("userName");
    	String pwd = request.getParameter("passWord");
    	if(userName.equals("infinite") && pwd.equals("infinite")){
    	%>
    	<jsp:forward page="Menu.jsp"/>
    	<% 
    	}else{
    		out.println("Invalid Cresentials");
    	}
    }
    %>
</body>
</html>