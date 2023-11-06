<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insurance Records</title>
    <style>
        /* Body styling */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        /* Form container styling */
        h2 {
            text-align: center;
            color: #007BFF;
            padding: 10px;
        }

        /* DataTable styling */
        h:dataTable {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
        }

        h:column {
            border: 2px solid #007BFF;
            padding: 10px;
            text-align: center;
        }

        /* Header facet styling */
        h:column[f:facetName="header"] {
            background-color: #007BFF;
            color: white;
        }
    </style>
</head>

<body>
    <h:form>
        <center>
            <h2>Insurance Records</h2>
        </center>
        <center>
        <h:dataTable value="#{paginationCus.getCustomerList()}" var="c" border="3">
            <h:column>
                <f:facet name="header">
                    <h:outputLabel value="Customer Id" />
                </f:facet>
                <h:outputText value="#{c.custId}" />
            </h:column>
            <h:column>
                <f:facet name="header">
                    <h:outputLabel value="First Name" />
                </f:facet>
                <h:outputText value="#{c.firstName}" />
            </h:column>
            <h:column>
                <f:facet name="header">
                    <h:outputLabel value="Last Name" />
                </f:facet>
                <h:outputText value="#{c.lastName}" />
            </h:column>
            <h:column>
                <f:facet name="header">
                    <h:outputLabel value="Gender" />
                </f:facet>
                <h:outputText value="#{c.gender}" />
            </h:column>
            <h:column>
                <f:facet name="header">
                    <h:outputLabel value="DOB" />
                </f:facet>
                <h:outputText value="#{c.dob}" />
            </h:column>
            <h:column>
                <f:facet name="header">
                    <h:outputLabel value="Username" />
                </f:facet>
                <h:outputText value="#{c.userName}" />
            </h:column>
            <h:column>
                <f:facet name="header">
                    <h:outputLabel value="Status" />
                </f:facet>
                <h:outputText value="PENDING" />
            </h:column>
            
        </h:dataTable>
        <!-- The paging buttons -->
<h:commandButton value="first" action="#{paginationCus.pageFirst}"
                 disabled="#{paginationCus.firstRow == 0}" />
<h:commandButton value="prev" action="#{paginationCus.pagePrevious}"
                 disabled="#{paginationCus.firstRow == 0}" />
<h:outputText value="&nbsp;" escape="false" />
<h:commandButton value="next" action="#{paginationCus.pageNext}"
                 disabled="#{paginationCus.firstRow + paginationCus.rowsPerPage >= paginationCus.totalRows}" />
<h:outputText value="&nbsp;" escape="false" />
<h:commandButton value="last" action="#{paginationCus.pageLast}"
                 disabled="#{paginationCus.firstRow + paginationCus.rowsPerPage >= paginationCus.totalRows}" />
<h:outputText value="&nbsp;" escape="false" />
<h:outputText value="Page #{paginationCus.currentPage} / #{paginationCus.totalPages}" />
<br />
<!-- Set rows per page -->
<h:outputLabel for="rowsPerPage" value="Rows per page" />
<h:inputText id="rowsPerPage" value="#{paginationCus.rowsPerPage}" size="3" maxlength="3" />
<h:commandButton value="Set" action="#{paginationCus.pageFirst}" />
<h:message for="rowsPerPage" errorStyle="color: red;" />
        
        </center>

        
    </h:form>
</body>

</html>
</f:view>
