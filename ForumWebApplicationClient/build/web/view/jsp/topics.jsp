<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Topics Page</title>
    </head>
    <body align="center">
        <div class="container" align="center">
            <table  border="1" style="backgroundcolor:white"><br/>
                <caption>Check out these topics!!!</caption>
                <thead>
                    <tr>
                        <td><b>Topic</b></td>
                        <td><b>User</b></td>
                        <td><b>Date Created</b></td>
                    </tr>                 
                </thead>
                <tbody>
                    <c:forEach items="${topicModelCache}" var="topicModelCache">
                        <tr>
                            <td><a href="view/jsp/comments.jsp?topicName=${topicModelCache.topicName}" >${topicModelCache.topicName}<a/></td>
                            <td>${topicModelCache.user}</td>
                            <td>${topicModelCache.date}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        </br>
        <a href="view/jsp/createTopic.jsp" >Add Topic</a>
    </body>
</html>
