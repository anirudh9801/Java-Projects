<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
	<h:form>
       <h1> WeLcome To HomePage</h1>
		<h:commandLink action="CustomerLogin">
			<h:outputLabel value="Customer Login" />
		</h:commandLink>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <h:commandLink action="VendorLogin">
    <h:outputLabel value="Vendor Login" />
      </h:commandLink>

  
        
     </h:form>
	</html>
</f:view>