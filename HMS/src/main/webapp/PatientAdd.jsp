<%@ page contentType="text/html" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<f:view>
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
<body>
    <h2>Create Employee</h2>
    <h:form>
        <h2 style="text-align: center" class="col-sm-4">Patient Record</h2>
         Patient id
        <h:inputText id="id" value="#{patient.pid}" />
        <br></br>
        Patient name
        <h:inputText id="name" value="#{patient.name}" />
        <br></br>
        Age
        <h:inputText id="age" value="#{patient.age}" />
        <br></br>
        Weight
        <h:inputText id="weight" value="#{patient.weight}" />
        <br></br>
        Gender
        <h:inputText id="gender" value="#{patient.gender}" />
        <br></br>
        Address
        <h:inputText id="address" value="#{patient.address}" />
        <br></br>
        Phoneno
        <h:inputText id="phone" value="#{patient.phoneno}" />
        <br></br>
        Disease
        <h:inputText id="disease" value="#{patient.disease}" />
        <br></br>
        Doctor Id
        <h:inputText id="did" value="#{patient.doctorid}" />
        <br></br>
        <h:commandButton value="Save" action="#{patientDao.addPatient(patient)}"></h:commandButton>
    </h:form>
</body>
    </html>
</f:view>
