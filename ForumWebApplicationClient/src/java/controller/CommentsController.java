/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import forumServiceConsume.CommentsModel;
import forumServiceConsume.ForumService;
import forumServiceConsume.ForumService_Service;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CommentsController extends HttpServlet{  
    
    public void doPost (HttpServletRequest request, HttpServletResponse response){
        CommentsModel commentsModel = new CommentsModel();
        commentsModel.setTopic(request.getParameter("topicHeading"));
        commentsModel.setComment(request.getParameter("user_comment"));
        commentsModel.setUser("Jason");
        
        ForumService_Service service = new ForumService_Service();
        ForumService port = service.getForumServicePort();
        port.addComments(commentsModel);
        
        //response.sendRedirect("view/jsp/comments.jsp");
        
        
    }
}
