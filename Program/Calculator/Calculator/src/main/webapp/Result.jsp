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
                <h2><h:outputText value="Calculation"/></h2>
            </center>
                              <h:outputText value="sum is #{sum}" />
             <center>
             &nbsp;&nbsp;
             </center>
                              <h:outputText value="subtraction is #{sub}" />
             <center>
             &nbsp;&nbsp;
             </center>
                              <h:outputText value="multiplication is #{mult}" />
             <center>
             &nbsp;&nbsp;
             </center>
                              <h:outputText value="Division is #{divi}" />
             </center>       
        
        </h:form>
    </body>
</html>
</f:view>
