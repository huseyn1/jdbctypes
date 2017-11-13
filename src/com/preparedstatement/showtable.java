
package com.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.driver.OracleDriver;

public class showtable {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
    // DriverManager.registerDriver(new OracleDriver());
    Class.forName("oracle.jdbc.driver.OracleDriver");
          
    Connection conn=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    
    List<UserModel> userList=new ArrayList<>();
    
    String sql="select first_name,last_name,e_mail,password from user_table";
    
        try {
            conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "hr", "hr");
        } catch (SQLException ex) {
         ex.printStackTrace();
            System.out.println("was error while connection");
          conn.close();
                 
        }
        
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
            UserModel model=new UserModel(rs.getString("first_name"),
                                          rs.getString("last_name"),
                                          rs.getString("e_mail"),
                                          rs.getString("password"));
            userList.add(model);
            }
            
        } catch (SQLException ex) {
             ex.printStackTrace();
             System.out.println("was error while executing");
        }
        
        for (UserModel model : userList){
        
            System.out.println(model.getFirstName()+" "+model.getLastName()+" "+model.geteMail()+" "+model.getPassword());
        }
        
        rs.close();
        ps.close();
        conn.close();
    
     
    }
    
 
}
