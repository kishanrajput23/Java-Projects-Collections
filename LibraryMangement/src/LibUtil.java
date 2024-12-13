
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author testuser
 */
public class LibUtil {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Properties prop = new Properties();
            FileInputStream in = new FileInputStream("src/DBProperties");
            prop.load(in);
            
            String driverName= prop.getProperty("DBDriver");
            Class.forName(driverName);
            
            String dbName,user,password;
            dbName= prop.getProperty("DBName");
            user = prop.getProperty("User");
            password= prop.getProperty("Password");
            
            conn= DriverManager.getConnection(dbName, user, password);
            return conn;
        } catch (Exception e) {
        }
        return conn;
        
    }
}
