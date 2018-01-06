/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forumService;

import controller.DatabaseController;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.CommentsModel;
import model.LoginModel;
import model.RegistrationModel;
import model.TopicModel;

/**
 *
 * @author Keagan
 */
@WebService(serviceName = "ForumService")
public class ForumService {

   
    //this method receives the parameters set from the web page. It the creates an instance of the database controller 
    //in order to use the methods in the database controller. It uses the register() method to insert the records into 
    //the database.it then returns the updated model and stores it into a registration model which gets returned to the 
    //front end controller for further validation
    
    @WebMethod(operationName = "registerUser")
    public RegistrationModel registerUser(@WebParam(name = "register") RegistrationModel registrationModel) {

        DatabaseController databaseController = new DatabaseController();
        registrationModel = databaseController.register(registrationModel);

        return registrationModel;

    }

    @WebMethod(operationName = "loginUser")
    public LoginModel loginUser(@WebParam(name = "login") LoginModel loginModel) {
        DatabaseController databaseController = new DatabaseController();
        loginModel = databaseController.login(loginModel);

        return loginModel;
    }

    @WebMethod(operationName = "addTopic")
    public TopicModel addTopic(@WebParam(name = "topic") TopicModel topicModel) {
        DatabaseController databaseController = new DatabaseController();
        databaseController.addTopic(topicModel);

        return null;
    }

    @WebMethod(operationName = "retrieveTopics")
    public List<TopicModel> retrieveTopics(@WebParam(name = "retrieveTopic") TopicModel topicModel) {
        
        List<TopicModel> topicModelCache = new ArrayList<>();
        
        DatabaseController databaseController = new DatabaseController();
        topicModelCache = databaseController.retrieveTopics();
        return topicModelCache;
    }
    
     @WebMethod(operationName = "addComments")
    public void  addComment(@WebParam(name = "addComments") CommentsModel commentModel) {
        
        DatabaseController databaseController = new DatabaseController();
        databaseController.addComment(commentModel);
        
    }
    
    

}
