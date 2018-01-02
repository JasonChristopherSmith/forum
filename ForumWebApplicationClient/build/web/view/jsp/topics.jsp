<%-- 
    Document   : topics
    Created on : 29 Dec 2017, 4:01:55 PM
    Author     : Keagan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Topics Page</title>
    </head>
    <body>
        <form action="../../TopicController" method="POST">
        <h1>Check out these topics!!!</h1>
        <br/>
        Add Topic: <input type="text" name="newTopic"/>
        <input type="submit" value="Add Topic"/> 
        </form>
    </body>
</html>
