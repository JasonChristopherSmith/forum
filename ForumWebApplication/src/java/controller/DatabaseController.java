
package controller;

import dao.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.ws.Response;
import model.LoginModel;
import model.RegistrationModel;
import model.TopicModel;

// Database control-->  1.Insert a new User into the database
//                      2.Check that the person is not alreay registered
//                      3.At Login, checks the registered user and password
//                      4.Insert a new Topic into the database
//                      5.Retrieves topics from the database
//                      6.Add Comments into the database
//                      7.Retrieve comments to add more comments
//                      8.Add Replies
//                      9.Retrieve Replies

//                      ForumService.java calls all the methods from DatabaseController.java

public class DatabaseController {

    public RegistrationModel register(RegistrationModel registrationModel) {

        //will always first GET the information which was originally set by the RegistrationModel on the jsp page. 
        String firstName = registrationModel.getName();
        String surname = registrationModel.getSurname();
        String mobile = registrationModel.getMobile();
        String email = registrationModel.getEmail();
        String password = registrationModel.getPassword();

        //before the new user information can be inserted into a database, a check must be performed to see if this 
        //user has already been registered into the database. therefore the checkRegistraion() method is called from 
        //within the current DatabaseController class.Gets returned into a registrationModel variable.
        registrationModel = checkRegistration(registrationModel);

        if (registrationModel.getMessage().equals("emailExists")) {
            return registrationModel;
        } else if (registrationModel.getMessage().equals("notExists")) {

            DatabaseConnection dataBaseConnection = new DatabaseConnection();
            dataBaseConnection.insertDataBase("INSERT INTO UserDetails(FirstName,Surname,Mobile,Email,Password)"
                    + "Values('" + firstName + "','" + surname + "',' " + mobile + "','" + email + "','" + password + "')");
        }

        return registrationModel;

    }

    public RegistrationModel checkRegistration(RegistrationModel registrationModel) {

        //instance variable for anything being returned from the dao packages, DatabaseConnection class, 
        //using the retrieveDatabase() method.
        ResultSet resultSet;

        //Only the email is being checked as the email is the user. email is stored in a variable called "emailCheck"
        String emailCheck = registrationModel.getEmail();

        DatabaseConnection databaseConnection = new DatabaseConnection();

        //in our dao package we have two methods which either insert into the database or retrieve from the database. 
        //insert
        resultSet = databaseConnection.retrieveDatabase("SELECT Email FROM UserDetails WHERE Email = '" + emailCheck + "'");

        try {

            //if the ResultSet returns an email from the database that is the same as the email from the registrationModel,
            //then the "message" attribute of the registrationModel will be set to "emailExists". This will be returned to 
            //the register() method as "emailExists" and the Database controller will return the registrationModel to
            //  the ForumService.java, register() method which will return the model to the front end RegistrationController
            // which accepts the model and calls the getMessage() method and if the message is "emailExists" then
            // a message will be returned back to the register.jsp page that the email already exists in the database
            
            if (resultSet.next()) {

                registrationModel.setMessage("emailExists");

                return registrationModel;

            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        registrationModel.setMessage("notExists");
        return registrationModel;
    }
    
    public LoginModel login(LoginModel loginModel) {

        ResultSet resultSet;

        String email = loginModel.getEmail();
        String password = loginModel.getPassword();

        DatabaseConnection databaseConnection = new DatabaseConnection();
        resultSet = databaseConnection.retrieveDatabase("SELECT Email,Password FROM UserDetails WHERE Email = '" + email + "' AND Password = '" + password + "'   ");

        try {
            if (resultSet.next()) {
                loginModel.setMessage("loginExists");
                return loginModel;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        loginModel.setMessage("Not Registered");
        return loginModel;

    }

    public void addTopic(TopicModel topicModel) {

        String topicName = topicModel.getTopicName();
        String user = "Jason";
        Date date = new Date();
        

        DatabaseConnection databaseConnection = new DatabaseConnection();
        databaseConnection.insertDataBase("INSERT INTO Topics (TopicName,User,DateCreated) VALUES ('" + topicName + "','" + user + "','" + date + "')");

        System.out.println(date);
    }

    public List<TopicModel> retrieveTopics() {

        List<TopicModel> topicModelCache = new ArrayList<>();

        try {
            ResultSet resultSet;

            DatabaseConnection databaseConnection = new DatabaseConnection();
            resultSet = databaseConnection.retrieveDatabase("SELECT ID,TopicName,User,DateCreated FROM Topics");

            while (resultSet.next()) {
                TopicModel topicModel = new TopicModel();
                topicModel.setTopicName(resultSet.getString("TopicName"));
                topicModel.setUser(resultSet.getString("User"));
                topicModel.setDate(resultSet.getString("DateCreated"));

                topicModelCache.add(topicModel);

            }

            return topicModelCache;

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void addComment(){}
    public void retrieveComment(){}
    public void addReply(){}
    public void retrieveReply(){}

}
