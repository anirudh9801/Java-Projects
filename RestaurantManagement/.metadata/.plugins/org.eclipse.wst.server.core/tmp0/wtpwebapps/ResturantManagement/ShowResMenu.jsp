<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
	<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
	<h:form>
		<center>
			<h2>
				<h:outputText value="Restaurant Menu" />
			</h2>
		</center>
		<center>
		<h:selectOneMenu id="localCode" value="#{resDao.localCode}" onchange="submit()"
	valueChangeListener="#{resDao.restaurantLocaleCodeChanged}">
	<f:selectItems value="#{resDao.getRestaurant()}"/>
	</h:selectOneMenu>
	<h:outputLabel id="heading" value="Selected Department is "/>
	


			<%-- <h:selectOneMenu value = "#{resDao.localCode}" onchange="submit()"
          valueChangeListener="#{resDao.restaurantLocaleCodeChanged}">
          
        </h:selectOneMenu>
        <h:outputLabel value = "Select Restaurant Is:"/>
        <h:outputText value = "#{resDao.localCode}"/> --%>

		</center>
	</h:form>
</body>
	</html>
</f:view>