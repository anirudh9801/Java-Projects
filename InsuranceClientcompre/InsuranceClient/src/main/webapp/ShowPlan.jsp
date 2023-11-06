<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Policy Records</title>
        <style>
            /* Body styling */
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                min-height: 100vh;
            }
            
            /* Form container styling */
            h2 {
                text-align: center;
                color: #007BFF;
                padding: 10px;
            }

            /* DataTable styling */
            h:dataTable {
                width: 80%;
                border-collapse: collapse;
                margin: 20px auto;
                border: 1px solid #007BFF;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                background-color: #fff;
            }

            h:column {
                border: 1px solid #007BFF;
                padding: 10px;
                text-align: center;
            }

            /* Header facet styling */
            h:column[f:facetName="header"] {
                background-color: #007BFF;
                color: white;
            }
        </style>
    </head>
    <body>
        <h:form>
            <center>
                <h2>Policy Records</h2>
            </center>
            <center>
            <h:dataTable value="#{insList}" var="e" border="3">
                <h:column>
                    <f:facet name="header">
                        <h:outputLabel value="Plan Id" />
                    </f:facet>
                    <h:outputText value="#{e.planId}" />
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputLabel value="Insurance Id" />
                    </f:facet>
                    <h:outputText value="#{e.insuranceId}" />
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputLabel value="Premium Amount" />
                    </f:facet>
                    <h:outputText value="#{e.premiumAmount}" />
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputLabel value="Coverage Amount" />
                    </f:facet>
                    <h:outputText value="#{e.coverageAmount}" />
                </h:column>
                  <h:column>
                <f:facet name="header">
                    <h:outputLabel value="Plan Booking" />
                </f:facet>
                <h:commandButton value="Book Plan" action="#{cImpl.planBooking(e.planId)}" />
            </h:column>
              
            </h:dataTable>
            </center>
        </h:form>
    </body>
</html>
</f:view>
