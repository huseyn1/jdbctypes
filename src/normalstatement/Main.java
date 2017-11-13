
package normalstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    
    public static void main(String[] args) {
        
        try {
            Class.forName("com.oracle.jdbc.driver");
        } catch (ClassNotFoundException ex) {
        ex.printStackTrace();
            System.out.println("execute error in driver register");
         }
        
        try {
            Connection connection=DriverManager.getConnection("", "", "");
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from user_table");
            while (resultSet.next()){
            
                System.out.println(resultSet.getInt("")+"");
            }
            } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
