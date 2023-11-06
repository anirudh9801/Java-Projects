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
        <h:form>
            <center>
                <h2><h:outputText value="Doctor Records" /></h2>
            </center>
            <h:dataTable value="#{roomDao.showDoctorsDao()}" var="e" border="3">
                <h:column>
                    <f:facet name="header">
                        <h:outputLabel value="Doctor id" />
                    </f:facet>
                    <h:outputText value="#{e.roomno}" />
                </h:column>
            </h:dataTable>
        </h:form>
    </body>
    </html>
</f:view>
