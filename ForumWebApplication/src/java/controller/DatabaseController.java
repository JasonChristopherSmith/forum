/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.LoginModel;
import model.RegistrationModel;
import model.TopicModel;

/**
 *
 * @author Keagan
 */
public class DatabaseController {

    public RegistrationModel register(RegistrationModel registrationModel) {      //expects a set bean from the set registration model

        String firstName = registrationModel.getName();
        String surname = registrationModel.getSurname();
        String mobile = registrationModel.getMobile();
        String email = registrationModel.getEmail();
        String password = registrationModel.getPassword();

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

        ResultSet resultSet;
        String emailCheck = registrationModel.getEmail();

        DatabaseConnection databaseConnection = new DatabaseConnection();
        resultSet = databaseConnection.retrieveDatabase("SELECT Email FROM UserDetails WHERE Email = '" + emailCheck + "'");

        try {
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
            if (resultSet.next()){
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

}
