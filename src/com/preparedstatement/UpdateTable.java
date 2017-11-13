
package com.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.driver.OracleDriver;

public class UpdateTable {
    
    public static void main(String[] args) {
        
        try {
            DriverManager.registerDriver(new OracleDriver());
        } catch (SQLException ex) {
            System.out.println("was error while registering");
        }
        
        int id=142;
        
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet resultSet=null;
        
        String sql="update user_table set first_name='Johan'"
                 + "where id=?";
        
        try {
            connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "hr", "hr");
        } catch (SQLException ex) {
            System.out.println("was error while updating");
        }
        
        try {
            ps=connection.prepareStatement(sql);
            ps.setInt(1, id);
            int respnum=ps.executeUpdate();
            System.out.println("respnum");
            connection.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("executing zamani xeta oldu");
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
