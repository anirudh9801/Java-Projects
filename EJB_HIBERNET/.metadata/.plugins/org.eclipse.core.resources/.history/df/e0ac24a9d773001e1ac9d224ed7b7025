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
                <h2><h:outputText value="Insurance Records"/></h2>
            </center>
        <h:dataTable value="#{eImpl.showInsuranceDao()}" var="e" border="3">
              	    <h:column>
                    <f:facet name="header">
                    	<h:outputLabel value="Insurance Id" />
                    </f:facet>
                    <h:outputText value="#{e.insuranceId}"/>
                </h:column>
                    <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Insurance Name" />
                    </f:facet>

                    <h:outputText value="#{e.insuranceName}"/>

                </h:column>

                <h:column>

                     <f:facet name="header">

                    	<h:outputLabel value="Insurance type" />

                    </f:facet>

                    <h:outputText value="#{e.insuranceType}"/>
                </h:column>                    
                
                 <h:column>

                     <f:facet name="header">

                    	<h:outputLabel value="Premium start" />

                    </f:facet>

                    <h:outputText value="#{e.premiumStart}"/>
                </h:column>   
                
                
                
                
                
                 <h:column>

                     <f:facet name="header">

                    	<h:outputLabel value="premium end" />

                    </f:facet>

                    <h:outputText value="#{e.premiumEnd}"/>
                </h:column>   
                
                
                
                
                 <h:column>

                     <f:facet name="header">

                    	<h:outputLabel value="Min period" />

                    </f:facet>

                    <h:outputText value="#{e.minPeriod}"/>
                </h:column>   
                
                
                  <h:column>

                     <f:facet name="header">

                    	<h:outputLabel value="Max period" />

                    </f:facet>

                    <h:outputText value="#{e.maxPeriod}"/>
                </h:column> 
                
                
                  <h:column>

                     <f:facet name="header">

                    	<h:outputLabel value="Launch Date" />

                    </f:facet>

                    <h:outputText value="#{e.launchDate}"/>
                </h:column> 
                
                
                  <h:column>

                     <f:facet name="header">

                    	<h:outputLabel value="Status" />

                    </f:facet>

                    <h:outputText value="#{e.status}"/>
                </h:column> 
                                   
        </h:dataTable>        

        

        </h:form>

    </body>

</html>

</f:view>