/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forumService;

import controller.DatabaseController;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.LoginModel;
import model.RegistrationModel;
import model.TopicModel;

/**
 *
 * @author Keagan
 */
@WebService(serviceName = "ForumService")
public class ForumService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    @WebMethod(operationName = "registerUser")
    public  RegistrationModel registerUser( @WebParam(name = "register")RegistrationModel registrationModel){
        
        DatabaseController databaseController = new DatabaseController();
        registrationModel = databaseController.register(registrationModel);
        
        return registrationModel;
        
    }
    @WebMethod(operationName = "loginUser")
    public LoginModel loginUser (@WebParam(name="login")LoginModel loginModel){
        DatabaseController databaseController = new DatabaseController();
        loginModel = databaseController.login(loginModel);
        
        return loginModel;
    }
    @WebMethod(operationName = "addTopic")
    public TopicModel addTopic (@WebParam(name="topic")TopicModel topicModel){
    DatabaseController databaseController = new DatabaseController();
    databaseController.addTopic(topicModel);
    
    return null;
    }
    
    
}
