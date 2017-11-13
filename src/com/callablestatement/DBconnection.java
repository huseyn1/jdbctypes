
package com.callablestatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBconnection {
    
private static final String DB_DRIVER_CLASS="oracle.jdbc.driver.OracleDriver";
private static final String DB_URL="jdbc:oracle:thin:@localhost:1521:ORCL";
private static final String DB_USERNAME="hr";
private static final String DB_PASSWORD="hr";

public void registrDriver() throws ClassNotFoundException{

Class.forName(DB_DRIVER_CLASS);
    
}

public static Connection getConnect(){
   Connection conn;
    try {
        conn=DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        
    } catch (SQLException ex) {
        ex.printStackTrace();
        return null;
    }
    return conn;
}
    


    
}
