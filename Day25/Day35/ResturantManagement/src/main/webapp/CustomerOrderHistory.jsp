<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<!DOCTYPE html>
<f:view>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Order History</title>
</head>
<body>
    <center>
        <h1>Customer Order History</h1>
        <h:dataTable value="#{customerOrderHistoryBean}" var="e">
            <h:column>
                <f:facet name="header">
                    <h:outputText value="Order ID" />
                </f:facet>
                <h:outputText value="#{e.ordid}" />
            </h:column>
            <h:column>
                <f:facet name="header">
                    <h:outputText value="Order Date" />
                </f:facet>
                <h:outputText value="#{e.orddate}" />
            </h:column>
            <h:column>
                <f:facet name="header">
                    <h:outputText value="Total Amount" />
                </f:facet>
                <h:outputText value="#{e.ordbillamount}" />
            </h:column>
        </h:dataTable>
    </center>
</body>
</html>
</f:view>
