<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Agent List</title>
</head>
<body>
    <sql:setDataSource var="connection"
        driver="com.mysql.cj.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/exam"
        user="root"
        password="@Bibha9801"
    />
    <sql:query var="agentQuery" dataSource="${connection}">
        select * from Agent
    </sql:query>

    <table border="1" align="center">
        <tr>
            <th>Agent ID</th>
            <th>Agent Name</th>
            <th>City</th>
            <th>Gender</th>
            <th>Marital Status</th>
            <th>Premium</th>
        </tr>
        <c:forEach var="agent" items="${agentQuery.rows}">
            <tr>
                <td><c:out value="${agent.agentID}"/></td>
                <td><c:out value="${agent.name}"/></td>
                <td><c:out value="${agent.city}"/></td>
                <td><c:out value="${agent.gender}"/></td>
                <td><c:out value="${agent.maritalStatus}"/></td>
                <td><c:out value="${agent.premium}"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
