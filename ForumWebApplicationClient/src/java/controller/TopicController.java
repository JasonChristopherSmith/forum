/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.net.httpserver.HttpServer;
import forumServiceConsume.ForumService;
import forumServiceConsume.ForumService_Service;
import forumServiceConsume.TopicModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class TopicController extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        TopicModel topicModel = new TopicModel();
        List<TopicModel> topicModelCache = new ArrayList<>();
        HttpSession session = request.getSession(false);

        topicModel.setTopicName(request.getParameter("newTopic"));

        ForumService_Service service = new ForumService_Service();
        ForumService port = service.getForumServicePort();
        port.addTopic(topicModel);
        
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(TopicController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        topicModelCache = displayTopics();
        session.setAttribute("topicModelCache", topicModelCache);
        
        try {
            getServletContext().getRequestDispatcher("/view/jsp/topics.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(TopicController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TopicController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        

    }

    public List<TopicModel> displayTopics() {

        TopicModel topicModel = new TopicModel();
        List<TopicModel> topicModelCache = new ArrayList<>();

        ForumService_Service service = new ForumService_Service();
        ForumService port = service.getForumServicePort();

        topicModelCache = port.retrieveTopics(topicModel);
        return topicModelCache;

    }

}
