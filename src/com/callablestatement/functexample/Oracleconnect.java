
package com.callablestatement.functexample;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Oracleconnect {
    
private final String ORCL_DRIVER_CLASS="oracle.jdbc.driver.OracleDriver";
private final String ORCL_URL="jdbc:oracle:thin:@localhost:1521:ORCL";
private final String ORCL_USERNAME="hr";
private final String ORCL_PASSWORD="hr";

Connection conn=null;
CallableStatement cs=null;

public Connection getConnect(){

    
    try {
       Class.forName(ORCL_DRIVER_CLASS);
       conn=DriverManager.getConnection(ORCL_URL,ORCL_USERNAME,ORCL_PASSWORD);
    } catch (ClassNotFoundException ex) {
        ex.printStackTrace();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return conn;
}

public void closeConnect(){

    try {
        if(cs!=null) cs.close();
        if(conn!=null)conn.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    
} 

    
}
