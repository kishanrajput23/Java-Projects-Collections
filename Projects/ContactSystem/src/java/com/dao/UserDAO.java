/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.entity.User;
import java.sql.*;

/**
 *
 * @author VINIT
 */
public class UserDAO 
{
    private Connection con;
    
    
    public UserDAO(Connection con)
    {
        super();
        this.con = con; 
    }
        
    public boolean userRegister(User u)
    {
        boolean f = false;
        
        try
        {
            String sql = "INSERT into user(name,email,password) values(?,?,?)";
            
            PreparedStatement psmt = con.prepareStatement(sql);
            
            psmt.setString(1,u.getName());
            psmt.setString(2,u.getEmail());
            psmt.setString(3,u.getPassword());
            
            
           int i = psmt.executeUpdate();
                  
          if(i==1)
          {
              f = true;
          }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return f;
        
    }
    
    public User loginUser(String e,String p)
    {
     User user = null;
        
        try
        {
            String sql = "SELECT * from user where email=? and password=?";
            
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1,e);
            psmt.setString(2,p);
            
            
            ResultSet rs = psmt.executeQuery();
            
            while(rs.next())
            {
                user=new User();
                
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setPassword(rs.getString(4));
            }
            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        return user;
    }
}
