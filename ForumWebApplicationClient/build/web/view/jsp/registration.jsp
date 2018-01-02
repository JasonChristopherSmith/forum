<%-- 
    Document   : registration
    Created on : 28 Dec 2017, 3:14:26 PM
    Author     : Keagan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="../../RegistrationController" method="POST">
        <h1>Register Here!!!</h1>
        <br/>
        <p><font color="red"> ${errorMessage} </font></p>
        First Name:<input type="text" name="fname" value="${nameValue}" /><br/>
        Surname:<input type="text" name="sname" value="${surnameValue}"/><br/>
        Mobile number:<input type="text" name="mobile" value="${mobileValue}"/><br/>
        Email:<input type="text" name="email" value="${emailValue}"/><br/>
        Password:<input type="text" name="password"/><br/>
        Confirm Password:<input type="text" name="confirm"/><br/><br/><br/>
        <input type="submit" value="Register"/>
        </form>
    </body>
</html>
