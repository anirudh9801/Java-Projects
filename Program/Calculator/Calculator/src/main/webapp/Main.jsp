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
                <h2><h:outputText value="Employ Records"/></h2>
            </center>
                  <h:inputText value="#{calculation.num1}" /></br></br>
                  <h:inputText value="#{calculation.num2}" /></br></br>
                  
             <center>
        <h:commandButton action="#{calc.saveCalculation(calculation)}"
        	 value="sum" /> 
       </center>
               <center>
        <h:commandButton action="#{calc.subtract(calculation)}"
        	 value="sub" /> 
       </center>
              <center>
        <h:commandButton action="#{calc.multiply(calculation)}"
        	 value="mult" /> 
       </center>
              <center>
        <h:commandButton action="#{calc.division(calculation)}"
        	 value="divi" /> 
       </center>
        </h:form>
    </body>
</html>
</f:view>