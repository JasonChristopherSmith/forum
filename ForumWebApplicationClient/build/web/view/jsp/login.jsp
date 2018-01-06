<%-- 
    Document   : Login
    Created on : 29 Dec 2017, 12:32:18 PM
    Author     : Keagan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form action="../../LoginController" method="POST">
        <h1>Login to this awesome forum!!!</h1
        <br/>
        <p><font color="red"> ${loginErrorMessage} </font></p>
        Username:   <input type="text" name="email" value="${username}"/><br/>
        
        Password:   <input type="password" name="password" /><br/><br/>
        <input type="submit" value="Login"/>
        </form>
    </body>
</html>
