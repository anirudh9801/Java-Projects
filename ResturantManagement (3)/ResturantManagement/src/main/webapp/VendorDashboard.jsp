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
       
	<h2>	
	<h:outputText value="Vendor Dahshboard" />
	</h2>
	<h:form>
	   Welcome to : <b> <h:outputText value="#{loggedCustomer}" /></b>
	   <hr>
	<h:commandLink action="#{ vendorDao.venpendingOrder()}" value="" >
	 <h:outputLabel value="Pending Order" />
	</h:commandLink>
	</h:form>


    </body>
</html>
</f:view>