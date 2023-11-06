<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
<html>
    <head>
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
            }

            /* Input text styling */
            h:inputText {
                width: 100%;
                padding: 5px;
                margin-bottom: 10px;
            }

            /* Command button styling */
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
            <h2>OTP VERIFICATION</h2>

            <h:outputText value="User Name" />
            <h:inputText id="name" value="#{loginBean.username}" />

            <br /><br />

            <h:outputText value="OTP" />
            <h:inputText id="otp" value="#{loginBean.otp}" />

            <br /><br />

            <h:outputText value="Password" />
            <h:inputText id="password" value="#{loginBean.passcode}" />

            <br />

            <h:commandButton action="#{cImpl.verifyOtp(loginBean)}" value="Verify" />
            <h:commandButton type="reset" value="Reset" />
        </h:form>
    </body>
</html>
</f:view>
