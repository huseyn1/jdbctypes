
package com.callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCStoredProcedureWrite {
    
    public static void main(String[] args) {
        
        Connection conn=null;
        CallableStatement statement=null;
        
        Scanner input=new Scanner(System.in);
        System.out.println("enter user name");
        String name=input.nextLine();
        System.out.println("enter user sur name");
        String surname=input.nextLine();
        System.out.println("enter email");
        String email=input.nextLine();
        System.out.println("enter password");
        String password=input.nextLine();
        
        
        try {
            conn=DBconnection.getConnect();
            statement=conn.prepareCall("{call insertUser(?,?,?,?) }");
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setString(3, email);
            statement.setString(4, password);
            statement.executeUpdate();
            System.out.println("User Record Save Success:)");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("exception oldu");
        }
        
        finally{
        
            try {
                statement.close();
                conn.close();
                input.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
    }
    
}
