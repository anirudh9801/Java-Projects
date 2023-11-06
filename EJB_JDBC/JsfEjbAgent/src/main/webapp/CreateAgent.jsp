<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Add Agent Record</title>
        </head>
        <body>
            <h:form>
                <h2 style="text-align: center" class="col-sm-4">Add Agent Record</h2>
                <hr/>
                Agent ID
                <h:inputText id="agentID" value="#{agent.agentID}" /> <br/>
                Agent Name
                <h:inputText id="name" value="#{agent.name}" /> <br/>
               
                  Gender 
	<h:selectOneMenu value="#{agent.gender}">
		<f:selectItem itemValue="MALE" itemLabel="Male" />
    <f:selectItem itemValue="FEMALE" itemLabel="Female" />
</h:selectOneMenu>
                City 
                <h:inputText id="city" value="#{agent.city}" />
                  Premium 
                <h:inputText id="premium" value="#{agent.premium}" />
                  Marital Status 
                <h:inputText id="Maritalstatus" value="#{agent.maritalStatus}" />
                  
                <h:commandButton value="Insert"
                    action="#{agentEjbImpl.addAgentEjb(agentEjbImpl.editAgent)}" />
            </h:form>
        </body>
    </html>
</f:view>
