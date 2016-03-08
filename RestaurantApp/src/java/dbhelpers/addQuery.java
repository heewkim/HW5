/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbhelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Restaurants;


public class addQuery {
    private Connection conn;
   
   public addQuery()
   {
      Properties props = new Properties();
      InputStream instr = getClass().getResourceAsStream("dbconnection.properties");
         try {
            props.load(instr);
         } catch (IOException ex) {
            Logger.getLogger(addQuery.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
            instr.close();
         } catch (IOException ex) {
            Logger.getLogger(addQuery.class.getName()).log(Level.SEVERE, null, ex);
         }
      
      String driver = props.getProperty("driver.name");
      String url = props.getProperty("server.name");
      String username = props.getProperty("user.name");
      String passwd = props.getProperty("user.password");
      
      
      try {
         Class.forName(driver);
      } catch (ClassNotFoundException ex) {
         Logger.getLogger(addQuery.class.getName()).log(Level.SEVERE, null, ex);
      }
      try {
         conn = DriverManager.getConnection(url, username, passwd);
      } catch (SQLException ex) {
         Logger.getLogger(addQuery.class.getName()).log(Level.SEVERE, null, ex);
      }
   }
   public void doAdd (Restaurants restaurants)
   {
      try {
         String query = "INSERT INTO RESTAURANTS (RES_NAME,RES_PHONENUMBER,RES_ADDRESS,RES_SIGNITUREMENU) VALUES (?, ?, ?, ?)";
         
         PreparedStatement ps = conn.prepareStatement(query);
         
             ps.setString(1,restaurants.getResName());
             ps.setString(2,restaurants.getResPhonenumber());
             ps.setString(3,restaurants.getResAddress());
             ps.setString(4,restaurants.getResSigMenu());
         
         ps.executeUpdate();
         
      } catch (SQLException ex) {
         Logger.getLogger(addQuery.class.getName()).log(Level.SEVERE, null, ex);
      }
   }
}
