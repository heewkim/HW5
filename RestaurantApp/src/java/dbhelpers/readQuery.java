
package dbhelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Restaurants;

/**
 *
 * @author Kim
 */
public class readQuery {
    
    private Connection conn;
    private ResultSet results;
    
    public readQuery() {
        
        
        Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbconnection.properties");
         try {
            props.load(instr);
         } catch (IOException ex) {
            Logger.getLogger(readQuery.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
            instr.close();
         } catch (IOException ex) {
            Logger.getLogger(readQuery.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
       String driver = props.getProperty("driver.name");
      String url = props.getProperty("server.name");
      String username = props.getProperty("user.name");
      String passwd = props.getProperty("user.password");
        try {
         Class.forName(driver);
      } catch (ClassNotFoundException ex) {
         Logger.getLogger(readQuery.class.getName()).log(Level.SEVERE, null, ex);
      }
      try {
         conn = DriverManager.getConnection(url, username, passwd);
      } catch (SQLException ex) {
         Logger.getLogger(readQuery.class.getName()).log(Level.SEVERE, null, ex);
      }
      
   }
    
    public void doRead(){
        
        try {
            String query = "Select * from Restaurants";
            
            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(readQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
  
    }
     public String getHTMLtable(){
        String table ="";
        table +="<table border=1>";
        
        try {
            table += "<tr>";
         
            table += "<th>";
            table += "RESTAURANTID";
            table += "</th>";
            
            table += "<th>";
            table += "RES_NAME";
            table += "</th>";
            
            table += "<th>";
            table += "RES_PHONENUMBER";
            table += "</th>";
            
            table += "<th>";
            table += "RES_ADDRESS";
            table += "</th>";
            
            table += "<th>";
            table += "RES_SIGNITUREMENU";
            table += "</th>";
            
            
           
            table += "</tr>";
            while (this.results.next()){
                
                Restaurants restaurant = new Restaurants();
                restaurant.setResID(this.results.getInt("restaurantID"));
                restaurant.setResName(this.results.getString("res_Name"));
                restaurant.setResPhonenumber(this.results.getString("res_PhoneNumber"));
                restaurant.setResAddress(this.results.getString("res_Address"));
                restaurant.setResSigMenu(this.results.getString("res_SignitureMenu"));
                
              table +="<tr>";
                 table +="<td>";
                    table += restaurant.getResID();
                 table +="</td>";
                
                 table +="<td>";
                    table += restaurant.getResName();
                 table +="</td>";
                
                 table +="<td>";
                    table += restaurant.getResPhonenumber();
                 table +="</td>";
                
                 table +="<td>";
                    table += restaurant.getResAddress();
                 table +="</td>";
                
                 table +="<td>";
                    table += restaurant.getResSigMenu();
                 table +="</td>";
                
                 table += "<td>";
                    table += "<a href=delete?resID=" + restaurant.getResID() + "> Delete </a>";
                 table += "</td>";
            
               table +="</tr>";
                
            }   } catch (SQLException ex) {
            Logger.getLogger(readQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        table +="</table>";
        
                return table;
     
        
        
    }
    
}
