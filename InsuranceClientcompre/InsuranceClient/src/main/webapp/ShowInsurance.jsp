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
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
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
            border-collapse: collapse;
            margin: 20px auto;
            border: 1px solid #007BFF;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            background-color: #fff;
        }

        h:column {
            border: 1px solid #007BFF;
            padding: 10px;
            text-align: center;
        }

        /* Header facet styling */
        h:column[f:facetName="header"] {
            background-color: #007BFF;
            color: white;
        }

        /* Button styling */
        h:commandButton {
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
        }
    </style>
</head>

<body>
    <h:form>
        <center>
            <h2>Insurance Records</h2>
        </center>
                <center>
        
        <h:dataTable value="#{paginationDao.getInsuranceList()}" var="e" border="3">
            <h:column>
                <f:facet name="header">
                    <h:outputLabel value="Insurance Id" />
                </f:facet>
                <h:outputText value="#{e.insuranceId}" />
            </h:column>
            <h:column>
                <f:facet name="header">
                    <h:outputLabel value="Insurance Name" />
                </f:facet>
                <h:outputText value="#{e.insuranceName}" />
            </h:column>
            <h:column>
                <f:facet name="header">
                    <h:outputLabel value="Insurance Type" />
                </f:facet>
                <h:outputText value="#{e.insuranceType}" />
            </h:column>
            <h:column>
                <f:facet name="header">
                    <h:outputLabel value="Premium Start" />
                </f:facet>
                <h:outputText value="#{e.premiumStart}" />
            </h:column>
            <h:column>
                <f:facet name="header">
                    <h:outputLabel value="Premium End" />
                </f:facet>
                <h:outputText value="#{e.premiumEnd}" />
            </h:column>
            <h:column>
                <f:facet name="header">
                    <h:outputLabel value="Min Period" />
                </f:facet>
                <h:outputText value="#{e.minPeriod}" />
            </h:column>
            <h:column>
                <f:facet name="header">
                    <h:outputLabel value="Max Period" />
                </f:facet>
                <h:outputText value="#{e.maxPeriod}" />
            </h:column>
            <h:column>
                <f:facet name="header">
                    <h:outputLabel value="Launch Date" />
                </f:facet>
                <h:outputText value="#{e.launchDate}" />
            </h:column>
            <h:column>
                <f:facet name="header">
                    <h:outputLabel value="Status" />
                </f:facet>
                <h:outputText value="#{e.status}" />
            </h:column>
            <h:column>
                <f:facet name="header">
                    <h:outputLabel value="Insurance Plans" />
                </f:facet>
                <h:commandButton value="View Plans" action="#{cImpl.getInsurancePlans(e.insuranceId)}" />
            </h:column>
        </h:dataTable>
     
<!--The paging buttons-->
            <h:commandButton value="first" action="#{paginationDao.pageFirst}"
                             disabled="#{paginationDao.firstRow == 0}" />
            <h:commandButton value="prev" action="#{paginationDao.pagePrevious}"
                             disabled="#{paginationDao.firstRow == 0}" />
            <h:outputText value="&nbsp;" escape="false"/>
            <h:commandButton value="next" action="#{paginationDao.pageNext}"
                             disabled="#{paginationDao.firstRow + paginationDao.rowsPerPage >= paginationDao.totalRows}" />
            <h:outputText value="&nbsp;" escape="false"/>
            <h:commandButton value="last" action="#{paginationDao.pageLast}"
                             disabled="#{paginationDao.firstRow + paginationDao.rowsPerPage >= paginationDao.totalRows}" />
            <h:outputText value="&nbsp;" escape="false"/>
            <h:outputText value="Page #{paginationDao.currentPage} / #{paginationDao.totalPages}" />
            <br />
            <!-- Set rows per page -->
            <h:outputLabel for="rowsPerPage" value="Rows per page" />
            <h:inputText id="rowsPerPage" value="#{paginationDao.rowsPerPage}" size="3" maxlength="3" />
            <h:commandButton value="Set" action="#{paginationDao.pageFirst}" />
            <h:message for="rowsPerPage" errorStyle="color: red;" />
        </center>
 
    </h:form>
</body>

</html>
</f:view>