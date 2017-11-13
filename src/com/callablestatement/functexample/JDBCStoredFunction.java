
package com.callablestatement.functexample;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JDBCStoredFunction extends Oracleconnect{
    
    public static void main(String []args){
    
    Oracleconnect oracleconnect=new Oracleconnect();
    
        Connection conn = oracleconnect.getConnect();
        CallableStatement cs=null;
        int result;
        try {
            cs=conn.prepareCall("{?= call sum(?,?)}");  
            cs.setInt(2,15);
            cs.setInt(3,25);
            cs.registerOutParameter(1,Types.INTEGER);
            cs.execute();
            result=cs.getInt(1);
            System.out.println(result);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("hesablama zamani xeta oldu");
        }
        
        finally{
        try {
            cs.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        }
        
        oracleconnect.closeConnect();
    
    }
    
}
