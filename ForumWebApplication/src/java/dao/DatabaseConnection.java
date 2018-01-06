
package dao;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

//This class only has two methods. One method is for inserting records into a database (like in the case for adding users,
//topics and comments and the other method is for retriving data from the database into a ResultSet for checks and validations


public class DatabaseConnection {
    
    private Connection connection;
    private static String dbURL = "jdbc:odbc:UserDetails";
    private static String driver = "sun.jdbc.odbc.JdbcOdbcDriver"; 
    private Statement statement;
    private ResultSet resultSet;
    
    //method accepts a SELECT query
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
    //method accepts a SELECT query to perform function then returns a ResultSet
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
