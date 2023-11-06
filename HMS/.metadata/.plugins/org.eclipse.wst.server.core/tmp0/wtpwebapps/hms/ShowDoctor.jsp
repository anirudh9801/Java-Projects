<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ page import="com.java.hms.DoctorDAO" %>

<f:view>
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h:form>
            <center>
                <h2><h:outputText value="Doctor Records" /></h2>
            </center>
            <h:dataTable value="#{dDAO.showDoctors()}" var="doctor" border="3">
                <h:column>
                    <f:facet name="header">
                        <h:outputLabel value="DOCID" />
                    </f:facet>
                    <h:outputText value="#{doctor.docid}" />
                </h:column>
                <!-- Add more columns for other doctor attributes as needed -->
            </h:dataTable>
        </h:form>
    </body>
    </html>
</f:view>
