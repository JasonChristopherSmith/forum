<%-- 
    Document   : addTopic
    Created on : 06 Jan 2018, 10:10:24 AM
    Author     : Keagan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
        <h1>Add a new topic</h1>
        <form action="../../TopicController" method="POST">
            
            Add a new topic:<input type="text" name="newTopic"/><br/>
             <input type="submit" value="Add"/>
           
            
        </form>
    
</html>
