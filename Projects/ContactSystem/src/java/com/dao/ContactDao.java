/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.entity.Contact;
import java.sql.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author VINIT
 */
public class ContactDao {

    private Connection con;

    public ContactDao(Connection con) {
        super();
        this.con = con;
    }

    public boolean SaveContact(Contact c) {
        boolean f = false;

        try {
            String sql = "INSERT into contact(name,email,phno,about,userid) values(?,?,?,?,?)";

            PreparedStatement psmt = con.prepareStatement(sql);

            psmt.setString(1, c.getName());
            psmt.setString(2, c.getEmail());
            psmt.setString(3, c.getPhno());
            psmt.setString(4, c.getAbout());
            psmt.setInt(5, c.getUserId());

            int i = psmt.executeUpdate();

            if (i == 1) {
                f = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

    public List<Contact> getAllContact(int uId) {
        List<Contact> list = new ArrayList<Contact>();

        Contact c = null;

        try {
            String sql = "SELECT * from contact where userid=?";

            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setInt(1, uId);

            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {
                c = new Contact();
                c.setId(rs.getInt(1));
                c.setName(rs.getString(2));
                c.setEmail(rs.getString(3));
                c.setPhno(rs.getString(4));
                c.setAbout(rs.getString(5));

                list.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public Contact getContactbyId(int cid) {
        Contact c = new Contact();

        try {

            PreparedStatement psmt = con.prepareStatement("SELECT * from contact where id=?");
            psmt.setInt(1, cid);

            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {
                c.setId(rs.getInt(1));
                c.setName(rs.getString(2));
                c.setEmail(rs.getString(3));
                c.setPhno(rs.getString(4));
                c.setAbout(rs.getString(5));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
         
    } 
         

    public boolean UpdateContact(Contact c)
    {
        boolean f = false;

        try {
            String sql = "UPDATE contact set name=?,email=?,phno=?,about=? where id=?";

            PreparedStatement psmt = con.prepareStatement(sql);

            psmt.setString(1, c.getName());
            psmt.setString(2, c.getEmail());
            psmt.setString(3, c.getPhno());
            psmt.setString(4, c.getAbout());
            psmt.setInt(5, c.getId());

            int i = psmt.executeUpdate();

            if (i == 1) {
                f = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
      }
    
    public boolean DeleteContactById(int id)
    {
        boolean f = false;
        
        try 
        {
            String sql = "DELETE from contact where id=?";
            
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setInt(1,id);
            
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
    
    

 }


