<%@page import="com.java.agent.Gender"%>
<%@page import="com.java.agent.Agent"%>
<%@page import="com.java.agent.AgentDAO"%>
<%@page import="com.java.agent.AgentDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Add Agent</title>
</head>
<body>
<form method="get" action="AddAgent.jsp">
    <center>
        Agent ID:
        <input type="number" name="agentId" /><br/><br/>
        Agent Name:
        <input type="text" name="agentName" /><br/><br/>
        City:
        <input type="text" name="city" /><br/><br/>
        Gender:
        <select name="gender">
            <option value="MALE">Male</option>
            <option value="FEMALE">Female</option>
        </select><br/><br/>
        Marital Status:
        <select name="maritalStatus">
            <option value="0">0</option>
            <option value="1">1</option>
        </select><br/><br/>
        Premium:
        <input type="number" name="premium" /><br/><br/>
        <input type="submit" value="Add Agent" />
    </center>
</form>

<%
if (request.getParameter("agentId") != null && request.getParameter("premium") != null) {
    AgentDAO dao = new AgentDAOImpl();
    Agent agent = new Agent();
    agent.setAgentID(Integer.parseInt(request.getParameter("agentId")));
    agent.setName(request.getParameter("agentName"));
    agent.setCity(request.getParameter("city"));
    agent.setGender(Gender.valueOf(request.getParameter("gender")));
    agent.setMaritalStatus(Integer.parseInt(request.getParameter("maritalStatus")));
    agent.setPremium(Double.parseDouble(request.getParameter("premium")));
    dao.addAgentDao(agent);
%>
    <jsp:forward page="showAgent.jsp"/>
<%
}
%>
</body>
</html>