/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Keagan
 */
public class DatabaseConnection {
    
    private Connection connection;
    private static String dbURL = "jdbc:odbc:UserDetails";
    private static String driver = "sun.jdbc.odbc.JdbcOdbcDriver"; 
    private Statement statement;
    private ResultSet resultSet;
    
    public void insertDataBase(String query){
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(dbURL);
            statement = connection.createStatement();
            statement.executeQuery(query);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet retrieveDatabase (String query){
       try{
           Class.forName(driver);
            connection = DriverManager.getConnection(dbURL);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
       
       }catch (Exception ex){
           System.out.println(ex);
       } 
        return resultSet;
    }
    
}
