<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body align="center">
        <form action="../../CommentsController" method="POST">
        <h1>Add a comment to this discussion.</h1>
        <h3 ><input type="hidden" name="topicHeading" value="<%=request.getParameter("topicName") %>"/><%=request.getParameter("topicName") %></h3>
        <c:forEach items="${commentModelCache}" var="commentModelCache">
            ${commentModelCache.comment}
            ${commentModelCache.user}<br/><br/>
            <input type="submit" value="reply"/>
        </c:forEach>
</br>
        Comment:<br/>
        <textarea id="comment" name="user_comment" cols="20" rows="10"></textarea>
        <input type="submit" value="Add Comment"/>
        </form>
    </body>
</html>
