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
                <h2 style="text-align: center" class="col-sm-4">Add customer</h2>
            <hr/>


                    
FirstName     
 				    <h:inputText id="firstName" value="#{customer.firstName }" /> <br/><br/>	 
 				                
LastName      
 				    <h:inputText id="lastName" value="#{customer.lastName }" /> <br/><br/>
 				    
      
 				   Gender : <h:selectOneMenu id="gender" value="#{customer.gender}">
    <f:selectItem itemLabel="Select Gender" itemValue="" />
    <f:selectItem itemLabel="Male" itemValue="Male" />
    <f:selectItem itemLabel="Female" itemValue="Female" />
</h:selectOneMenu>
			    

					<h:outputLabel for="dob">DOB : </h:outputLabel>  
					<h:inputText id="dob" value="#{customer.dob}">  
					<f:convertDateTime pattern="dd/mm/yyyy" />  
					</h:inputText><br/>  				    
    

UserName    
 				    <h:inputText id="userName" value="#{customer.userName }" /> <br/><br/>

 
 				    
 
 				    
 				    
                    <h:commandButton value="Add Customer" 
                    	action="#{cImpl.addCustomer(customer)}" />
                    	
                    	  <h:commandButton value="Show Customer Details" 
                    	action="ShowCustomer" />
        
        </h:form>
    </body>
    
</html>
</f:view>