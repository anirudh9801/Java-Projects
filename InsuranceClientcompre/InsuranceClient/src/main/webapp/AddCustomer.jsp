<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <style>
            /* Page background color */
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 0;
                text-align: center;
            }
            /* Title text color and background color */
            .col-sm-4 {
                text-align: center;
                font-size: 24px;
                color: #007BFF;
                background-color: #f4f4f4;
                padding: 10px;
                margin: 20px 0;
            }
        </style>
    </head>
  
    <body>
        <h:form>
            <h2 class="col-sm-4">Add customer</h2>
            <hr/>

            <!-- Apply styles to individual input elements -->
            <label style="font-weight: bold;">First Name</label>
            <h:inputText id="firstName" value="#{customer.firstName}" style="width: 100%;"/><br/><br/>

            <label style="font-weight: bold;">Last Name</label>
            <h:inputText id="lastName" value="#{customer.lastName}" style="width: 100%;"/><br/><br/>

            <label style="font-weight: bold;">Gender:</label>
            <h:selectOneMenu id="gender" value="#{customer.gender}" style="width: 100%;">
                <f:selectItem itemLabel="Select Gender" itemValue="" />
                <f:selectItem itemLabel="Male" itemValue="Male" />
                <f:selectItem itemLabel="Female" itemValue="Female" />
            </h:selectOneMenu>

            <label style="font-weight: bold;">DOB:</label>
            <h:inputText id="dob" value="#{customer.dob}" style="width: 100%;">
                <f:convertDateTime pattern="dd/MM/yyyy" />
            </h:inputText><br/><br/>

            <label style="font-weight: bold;">Username</label>
            <h:inputText id="userName" value="#{customer.userName}" style="width: 100%;"/><br/><br/>

            <label style="font-weight: bold;">Email</label>
            <h:inputText id="email" value="#{customer.email}" style="width: 100%;"/><br/><br/>

            
           <h:commandButton value="Add Customer" action="#{cImpl.addCustomer(customer)}" style="background-color: #007BFF; color: white; border: none; border-radius: 5px; padding: 10px 20px; cursor: pointer;"/>
           &nbsp; &nbsp;
            <h:commandButton value="Show Customer Details" action="ShowCustomer" style="background-color: #007BFF; color: white; border: none; border-radius: 5px; padding: 10px 20px; cursor: pointer;"/>
        </h:form>
    </body>
</html>
</f:view>
