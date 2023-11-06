<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view>
    <html>
    <body>
        <h:form>
            <h2>Booking</h2>
            <label for="policyId">Policy ID:</label>
            <h:outputText id="policyId" value="#{booking.policyId}" /> <br/>
            <label for="custId">Customer ID:</label>
            <h:outputText id="custId" value="#{booking.custId}" /><br/>
            
            <label for="planId">Plan ID:</label>
            <h:outputText id="planId" value="#{planBooking.planId}" /><br/>

            
            <label for="insuranceId">Insurance ID:</label>
            <h:outputText id="insuranceId" value="#{booking.insuranceId}" /><br/>
            
            <label for="premiumAmount">Premium Amount:</label>
            <h:outputText id="premiumAmount" value="#{booking.premiumAmount}"  /><br/>
            
            <label for="paymode">Payment Mode:</label>
            <h:selectOneMenu id="paymode" value="#{booking.paymode}">
            <f:selectItem  itemLabel="Select Payment mode" itemValue=""/>
            <f:selectItem  itemLabel="MONTHLY" itemValue="MONTHLY"/>
            <f:selectItem  itemLabel="YEARLY" itemValue="YEARLY"/>
            <f:selectItem  itemLabel="HALFYEARLY" itemValue="HALFYEARLY"/>
            <f:selectItem  itemLabel="QUATERLY" itemValue="QUATERLY"/>
            </h:selectOneMenu><br/>
            
            <label for="installmentAmount">Installment Amount:</label>
            <h:inputText id="installmentAmount" value="#{booking.installmentAmount}" /><br/>
            
          	<h:outputText value="Register Date " /> 
	<h:inputText id="registerDate" value="#{booking.registerDate}">  
		<f:convertDateTime pattern="dd-MM-yyyy"/>  
	</h:inputText><br/>
            
            <h:commandButton value="Submit" />
        </h:form>
    </body>
    </html>
</f:view>