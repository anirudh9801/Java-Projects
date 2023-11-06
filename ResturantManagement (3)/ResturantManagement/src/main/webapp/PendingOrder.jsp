<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
	<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>
	<h:dataTable value="#{orderList}" var="order" border="1">
		<h:column>
			<f:facet name="header">
				<h:outputText value="Order Id" />
			</f:facet>
			<h:outputText value="#{order.ordid}" />
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Customer Id" />
			</f:facet>
			<h:outputText value="#{order.cusid}" />
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Wallet source" />
			</f:facet>
			<h:outputText value="#{order.walsource}" />
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Vendor Id" />
			</f:facet>
			<h:outputText value="#{order.venid}" />
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Men ID" />
			</f:facet>
			<h:outputText value="#{order.menid}" />
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Order Date" />
			</f:facet>
			<h:outputText value="#{order.orddate}" />
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Order Quantity" />
			</f:facet>
			<h:outputText value="#{order.ordquantity}" />
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Order BillAmount" />
			</f:facet>
			<h:outputText value="#{order.ordbillamount}" />
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Order Comments" />
			</f:facet>
			<h:outputText value="#{order.ordcomments}" />
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Status" />
			</f:facet>
			<h:outputText value="#{order.ordstatus}" />
		</h:column>
	</h:dataTable>
</body>
	</html>
</f:view>
