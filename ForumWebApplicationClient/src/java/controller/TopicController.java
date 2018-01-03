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
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Keagan
 */
public class TopicController extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        TopicModel topicModel = new TopicModel();
        topicModel.setTopicName(request.getParameter("newTopic"));

        ForumService_Service service = new ForumService_Service();
        ForumService port = service.getForumServicePort();
        port.addTopic(topicModel);

        System.out.println("Topic Added");

    }

    public void displayTopics() {
        
        
        TopicModel topicModel = new TopicModel();
        List<TopicModel> topicModelCache = new ArrayList<>();
        
        ForumService_Service service = new ForumService_Service();
        ForumService port = service.getForumServicePort();
        
        topicModelCache = port.retrieveTopics(topicModel);

    }
}
