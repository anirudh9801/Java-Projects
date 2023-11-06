<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
	<h:form>
        Welcome to : <b> <h:outputText value="#{loggedVendor}" />
			<br /> <br />
		</b>
		<h:commandLink action="VendorInfo">
			<h:outputLabel value="Show Vendor Info" />
		</h:commandLink>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <h:commandLink action="#{ordersHis.venpendingOrder()}">
    <h:outputLabel value="Orders" />
      </h:commandLink>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  	<h:commandLink action="VendorLogin">
			<h:outputLabel value="Retrun To  Vendor Login Page" />
		</h:commandLink>
        
     </h:form>
	</html>
</f:view>