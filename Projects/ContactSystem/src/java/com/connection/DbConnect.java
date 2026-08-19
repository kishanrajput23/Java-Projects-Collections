package com.connection;

import java.sql.*;

/**
 *
 * @author VINIT
 */
public class DbConnect {

    
        private static Connection con = null;

        public static Connection getConnection() {
                try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        System.out.println("Driver loaded ho chuka hai");
                      
                        
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebook","root","root");
                        System.out.println("Connected");
                       
                         return con;
                        
                } catch (Exception e) {
                        e.printStackTrace();
                }
                
            return null;
   }

}
