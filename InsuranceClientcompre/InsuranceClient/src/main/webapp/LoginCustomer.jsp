<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<f:view>
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <style>
            /* Body styling */
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 0;
                text-align: center;
            }

            /* Form container styling */
            #form {
                background-color: #fff;
                border: 1px solid #ddd;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                padding: 20px;
                max-width: 400px;
                margin: 20px auto;
            }

            /* Title styling */
            h2 {
                color: #007BFF;
            }

            /* Label styling */
            h:outputText {
                display: block;
                margin-bottom: 5px;
                font-weight: bold;
                color: #333; /* Text color */
            }

            /* Input text and password input styling */
            h:inputText, h:inputSecret {
                width: 100%;
                padding: 10px;
                margin-bottom: 15px;
                border: 1px solid #ddd;
                border-radius: 5px;
            }

            /* Login button styling */
            h:commandButton {
                background-color: #007BFF;
                color: white;
                border: none;
                border-radius: 5px;
                padding: 10px 20px;
                cursor: pointer;
            }

            /* Reset button styling */
            h:commandButton[type="reset"] {
                background-color: #ccc;
            }
        </style>
    </head>
    <body>
        <h:form id="form">
            <h2>Login Page</h2>

            <h:outputText value="User Name" />
            <h:inputText id="username" value="#{loginBean.username}" /><br></br>
             
            <h:outputText value="Password" />
            <h:inputSecret id="password" value="#{loginBean.passcode}" /><br></br>

            <h:commandButton value="Login" action="#{cImpl.login(loginBean)}" />
            &nbsp;&nbsp;
            <h:commandButton type="reset" value="Reset" />
        </h:form>
    </body>
    </html>
</f:view>
