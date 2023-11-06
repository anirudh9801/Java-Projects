<%@page import="com.java.agent.Gender"%>
<%@page import="com.java.agent.Agent"%>
<%@page import="com.java.agent.AgentDAO"%>
<%@page import="com.java.agent.AgentDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Agent</title>
</head>
<body>
<%
    int agentId = Integer.parseInt(request.getParameter("agentId"));
    AgentDAO dao = new AgentDAOImpl();
    Agent agent = dao.searchAgentDao(agentId);
%>
<form method="post" action="UpdateAgent.jsp">
    <center>
        Agent ID:
        <input type="number" name="agentId" readonly="readonly" value="<%=agent.getAgentID() %>" /> <br/><br/>
        Agent Name:
        <input type="text" name="agentName" value="<%=agent.getName() %>" /> <br/><br/>
        City:
        <input type="text" name="city" value="<%=agent.getCity() %>" /> <br/><br/>
        Gender:
        <input type="text" name="gender" value="<%=agent.getGender() %>" /> <br/><br/>
        MaritalStatus:
        <input type="number" name="MaritalStatus" value="<%=agent.getMaritalStatus() %>" /> <br/><br/>
        Premium:
        <input type="number" name="premium" value="<%=agent.getPremium() %>" /> <br/><br/>
        <input type="submit" value="Update Agent" />
    </center>
</form>
<%
if(request.getParameter("agentId")!=null && request.getParameter("premium")!=null){
    Agent agentUpdated = new Agent();
    agentUpdated.setAgentID(Integer.parseInt(request.getParameter("agentId")));
    agentUpdated.setName(request.getParameter("agentName"));
    agentUpdated.setCity(request.getParameter("city"));
    agentUpdated.setGender(Gender.valueOf(request.getParameter("gender")));
    agentUpdated.setMaritalStatus(Integer.parseInt(request.getParameter("MaritalStatus")));
    agentUpdated.setPremium(Double.parseDouble(request.getParameter("premium")));
    dao.updateAgentDao(agentUpdated);
%>
    <jsp:forward page="showAgent.jsp"/>
<%
}
%>
</body>
</html>
