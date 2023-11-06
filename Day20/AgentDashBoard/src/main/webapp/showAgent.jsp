<%@page import="com.java.agent.Agent"%>
<%@page import="java.util.List"%>
<%@page import="com.java.agent.AgentDAOImpl"%>
<%@page import="com.java.agent.AgentDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Agent List</title>
</head>
<body>
    <%
        AgentDAO dao = new AgentDAOImpl();
        List<Agent> agentList = dao.showAgentDao();
    %>

    <table border="3" align="center">
        <tr>
            <th>Agent Id</th>
            <th>Agent Name</th>
            <th>City</th>
            <th>Gender</th>
            <th>Marital Status</th>
            <th>Premium</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        <%
        for(Agent agent : agentList){
        %>
        <tr>
            <td><%=agent.getAgentID()%> </td>
            <td><%=agent.getName() %> </td>
            <td><%=agent.getCity() %> </td>
            <td><%=agent.getGender()%> </td>
            <td><%=agent.getMaritalStatus()%> </td>
            <td><%=agent.getPremium() %> </td>
            	<td>
    <a href="UpdateAgent.jsp?agentId=<%=agent.getAgentID()%>">Update</a>
</td>
<td>
    <a href="DeleteAgent.jsp?agentId=<%=agent.getAgentID()%>">Delete</a>
</td>

            	
        </tr>
        <%
        }
        %>
    </table>
    <a href="AddAgent.jsp">Add Agent</a>
</body>
</html>
