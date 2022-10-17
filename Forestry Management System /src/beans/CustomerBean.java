// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 9/18/2008 6:07:19 PM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   CustomerBean.java

package beans;

import dbcon.JDBCConn;
//import java.io.PrintStream;
import java.sql.*;

public class CustomerBean
{

    public CustomerBean()
    {
    }

    public String getCname()
    {
        return cname;
    }

    public void setCname(String cname)
    {
        this.cname = cname;
    }

    public int getCustid()
    {
        return custid;
    }

    public void setCustid(int custid)
    {
        this.custid = custid;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPostcode()
    {
        return postcode;
    }

    public void setPostcode(String postcode)
    {
        this.postcode = postcode;
    }

    public String getStad1()
    {
        return stad1;
    }

    public void setStad1(String stad1)
    {
        this.stad1 = stad1;
    }

    public String getStad2()
    {
        return stad2;
    }

    public void setStad2(String stad2)
    {
        this.stad2 = stad2;
    }

    public int getTelno()
    {
        return telno;
    }

    public void setTelno(int telno)
    {
        this.telno = telno;
    }

    public String getTown()
    {
        return town;
    }

    public void setTown(String town)
    {
        this.town = town;
    }

    public int insert()throws Exception{
        
    	
    	
        Connection con = JDBCConn.getConnection();
        PreparedStatement pstmt = con.prepareStatement("insert into customer values(?,?,?,?,?,?,?,?)");
        pstmt.setInt(1, custid);
        pstmt.setString(2, cname);
        pstmt.setString(3, stad1);
        pstmt.setString(4, stad2);
        pstmt.setString(5, town);
        pstmt.setString(6, postcode);
        pstmt.setInt(7, telno);
        pstmt.setString(8, email);
       try
       {
        int i= pstmt.executeUpdate();
        System.out.println("data inserted");
        pstmt.close();
        con.close();
        return i;
       }
        catch(Exception e){
        return 0;
        
        }
       
       
        
    	}
    	
        
    
    public void select()throws Exception
    {
    	
        Connection con = JDBCConn.getConnection();
        System.out.println("In select of Case");
      // Statement stmt=con.createStatement();
      
       
       
        PreparedStatement pstmt = con.prepareStatement("select * from customer where customer_id=?");
        System.out.println("after pstmt");
        pstmt.setInt(1, custid);
        ResultSet rs = pstmt.executeQuery();
        System.out.println("entered into case java");
        
        if(rs.next())
        {
        	System.out.println("enter into the customer");
            custid = rs.getInt(1);
            cname = rs.getString(2);
            stad1 = rs.getString(3);
            stad2 = rs.getString(4);
            town = rs.getString(5);
            postcode = rs.getString(6);
            telno = rs.getInt(7);
            email = rs.getString(8);
            System.out.println(custid);
            System.out.println(cname);
            System.out.println(stad1);
            System.out.println(stad2);
            System.out.println(town);
            System.out.println(postcode);
            System.out.println(telno);
            System.out.println(email);
            System.out.println("....data retrieved....");
           
        }
      
    
    }

    public int delete(int articleid)
        throws Exception
    {
        Connection con = JDBCConn.getConnection();
        String query = "DELETE  FROM customer WHERE customer_id=" + custid;
        Statement stmt = con.createStatement();
        int i = stmt.executeUpdate(query);
        return i;
    }

    public int Update()
        throws Exception
    {
        System.out.println(toString());
        Connection con = JDBCConn.getConnection();
        Statement stmt = con.createStatement();
        int i = stmt.executeUpdate("update Customer SET Customer_Name = '" + cname + "', StreetAddress1 ='" + stad1 + "', StreetAddress2 = '" + stad2 + "', Town_City = '" + town + "', Postcode = '" + postcode + "', TelephoneNo = '" + telno + "', Email = '" + email + "' where Customer_id = " + custid);
        System.out.println("data updated");
        return i;
    }

    public String toString()
    {
        return custid + " " + cname + " " + stad1 + " " + stad2 + " " + town + " " + postcode + " " + telno + " " + email;
    }

    private int custid;
    private int telno;
    private String cname;
    private String stad1;
    private String stad2;
    private String town;
    private String postcode;
    private String email;
}