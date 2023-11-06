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
        <h:dataTable value="#{cImpl.showCustomer()}" var="c" border="3">
              	    <h:column>
                    <f:facet name="header">
                    	<h:outputLabel value="Customer Id" />
                    </f:facet>
                    <h:outputText value="#{c.custId}"/>
                </h:column>
                    <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="first Name" />
                    </f:facet>

                    <h:outputText value="#{c.firstName}"/>

                </h:column>
				 <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="last Name" />
                    </f:facet>

                    <h:outputText value="#{c.lastName}"/>

                </h:column>


		
                <h:column>

                     <f:facet name="header">

                    	<h:outputLabel value="gender" />

                    </f:facet>

                    <h:outputText value="#{c.gender}"/>
                </h:column>                    
                
                 <h:column>

                     <f:facet name="header">

                    	<h:outputLabel value="DOB" />

                    </f:facet>

                    <h:outputText value="#{c.dob}"/>
                </h:column>   
                
                
                
                
                
                 <h:column>

                     <f:facet name="header">

                    	<h:outputLabel value="username" />

                    </f:facet>

                    <h:outputText value="#{c.userName}"/>
                </h:column>   
                
                
                
                
                
                
                 
                
                
                  <h:column>

                     <f:facet name="header">

                    	<h:outputLabel value="Status" />

                    </f:facet>

                    <h:outputText value="PENDING"/>
                </h:column> 
                                   
        </h:dataTable>        

        

        </h:form>

    </body>

</html>

</f:view>