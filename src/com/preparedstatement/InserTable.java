
package com.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.driver.OracleDriver;

public class InserTable {
    
    public static void main(String[] args) {
        
        try {
            DriverManager.registerDriver(new OracleDriver());
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Driver Register zamani xeta oldu");
        }
        
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet resultSet=null;
        
        UserModel model=new UserModel("John", "Millet", "john@gmail.com", "john1234");
        
        String sql="insert into user_table (id,first_name,last_name,e_mail,password)"
                + " values (user_id_seq.nextval,?,?,?,?) ";
        
        try {
            connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "hr", "hr");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        try {
            ps=connection.prepareStatement(sql);
            ps.setString(1, model.getFirstName());
            ps.setString(2, model.getLastName());
            ps.setString(3, model.geteMail());
            ps.setString(4, model.getPassword());
            int respnum=ps.executeUpdate();
            System.out.println(respnum);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("was problem in inserting Dao");
        }
        
        try {
            resultSet.close();
            ps.close();
        connection.close();
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
}
