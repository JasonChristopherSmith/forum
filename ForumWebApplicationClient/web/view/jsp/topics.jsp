

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Topics Page</title>
    </head>
    <body>
        <form action="../../TopicController" method="POST">
        <h1>Check out these topics!!!</h1>
        
        <c:forEach  items="${topicModelCache}" var="topicModelCache">
            <tr>
                <td>${topicModelCache.topicName}</td><br/>
                <td>${topicModelCache.user}</td><br/><br/>
            </tr>
        </c:forEach>
        
        <br/>
        Add Topic: <input type="text" name="newTopic"/>
        <input type="submit" value="Add Topic"/> 
        </form>
    </body>
</html>
