
package com.blobfile;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    
    private static final String ORCL_DRIVER_CLASS="oracle.jdbc.driver.OracleDriver";
    private static final String ORCL_URL="jdbc:oracle:thin:@localhost:1521:ORCL";
    private static final String ORCL_USERNAME="hr";
    private static final String ORCL_PASSWORD="hr";

    public static void main(String[] args) {
        
        Connection conn=null;
        PreparedStatement ps=null;
        FileInputStream inputStream=null;
        String sql="insert into bfiles (id,myfile)"
                + " values (?,?)";
        try{
        File myfile=new File("D:\\cv\\mycv.pdf");
         inputStream=new FileInputStream(myfile);
        }
        catch(Exception ex){
        ex.printStackTrace();
        }
        
        try {
            Class.forName(ORCL_DRIVER_CLASS);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        try {
            conn=DriverManager.getConnection(ORCL_URL, ORCL_USERNAME, ORCL_PASSWORD);
            ps=conn.prepareStatement(sql);
            ps.setInt(1, 1);
            ps.setBinaryStream(2, inputStream);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
    }
    
}
