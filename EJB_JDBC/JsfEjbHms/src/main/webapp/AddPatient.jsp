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
		<h2 style="text-align: center" class="col-sm-4">Add Your Patient
			Record</h2>
		<hr />
Patient Id
                    <h:inputText id="id" value="#{patient.pid}" />
		<br />
Patient Name
                    <h:inputText id="name" value="#{patient.name}" />
		<br />
Age
                    <h:inputText id="age" value="#{patient.age}" />
		<br />
Weight
                    <h:inputText id="weight" value="#{patient.weight}" />
		<br />
Gender
                    <h:inputText id="gender" value="#{patient.gender}" />
		<br />
                    Address
                    <h:inputText id="basic" value="#{patient.address}" />
		<br />
                    Phone no
                    <h:inputText id="address" value="#{patient.phoneno}" />
		<br />
                    Disease
                    <h:inputText id="disease" value="#{patient.disease}" />
		<br />
                    Doctor_id
                    <h:inputText id="drid" value="#{patient.doctorid}" />
		<br />
		<br />
                    Email
                    <h:inputText id="email" value="#{patient.email}" />
		<br />
		
	
		<h:commandButton value="Insert"
			action="#{patientEjb.addPatientEjb(patient)}" />
	</h:form>
</body>
	</html>
</f:view>