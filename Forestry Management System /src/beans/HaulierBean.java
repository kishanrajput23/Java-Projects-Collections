// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 9/18/2008 6:07:50 PM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   HaulierBean.java

package beans;

import dbcon.JDBCConn;
//import java.io.PrintStream;
import java.sql.*;

public class HaulierBean
{

    public HaulierBean()
    {
    }

    public int getHaulid()
    {
        return haulid;
    }

    public void setHaulid(int haulid)
    {
        this.haulid = haulid;
    }

    public String getHemail()
    {
        return hemail;
    }

    public void setHemail(String hemail)
    {
        this.hemail = hemail;
    }

    public String getHname()
    {
        return hname;
    }

    public void setHname(String hname)
    {
        this.hname = hname;
    }

    public String getHpostcode()
    {
        return hpostcode;
    }

    public void setHpostcode(String hpostcode)
    {
        this.hpostcode = hpostcode;
    }

    public String getHstad1()
    {
        return hstad1;
    }

    public void setHstad1(String hstad1)
    {
        this.hstad1 = hstad1;
    }

    public String getHstad2()
    {
        return hstad2;
    }

    public void setHstad2(String hstad2)
    {
        this.hstad2 = hstad2;
    }

    public int getHtelno()
    {
        return htelno;
    }

    public void setHtelno(int htelno)
    {
        this.htelno = htelno;
    }

    public String getHtown()
    {
        return htown;
    }

    public void setHtown(String htown)
    {
        this.htown = htown;
    }

    public int insert()
        throws Exception
    {
        Connection con = JDBCConn.getConnection();
        PreparedStatement pstmt = con.prepareStatement("insert into haulier values(?,?,?,?,?,?,?,?)");
        pstmt.setInt(1, haulid);
        pstmt.setString(2, hname);
        pstmt.setString(3, hstad1);
        pstmt.setString(4, hstad2);
        pstmt.setString(5, htown);
        pstmt.setString(6, hpostcode);
        pstmt.setInt(7, htelno);
        pstmt.setString(8, hemail);
        try
        {
        int i = pstmt.executeUpdate();
        System.out.println("data inserted");
        pstmt.close();
        con.close();
        return i;
        }
        catch(Exception e){
        	return 0;
        }
    }

    public void select()
        throws Exception
    {
        Connection con = JDBCConn.getConnection();
        System.out.println("In select of Case");
        PreparedStatement pstmt = con.prepareStatement("select * from haulier where haulier_id=?");
        System.out.println("after pstmt");
        pstmt.setInt(1, haulid);
        ResultSet rs = pstmt.executeQuery();
        System.out.println("entered into case java");
        for(; rs.next(); System.out.println("....data retrieved...."))
        {
            haulid = rs.getInt(1);
            hname = rs.getString(2);
            hstad1 = rs.getString(3);
            hstad2 = rs.getString(4);
            htown = rs.getString(5);
            hpostcode = rs.getString(6);
            htelno = rs.getInt(7);
            hemail = rs.getString(8);
            System.out.println(haulid);
            System.out.println(hname);
        }

    }

    public int delete(int articleid)
        throws Exception
    {
        Connection con = JDBCConn.getConnection();
        String query = "DELETE  FROM haulier WHERE haulier_id=" + articleid;
        Statement stmt = con.createStatement();
        int i = stmt.executeUpdate(query);
        return i;
    }

    public int Update()
        throws Exception
    {
        Connection con = JDBCConn.getConnection();
        PreparedStatement pstmt = con.prepareStatement("update  haulier set Haulier_name = ?, StreetAddress1 = ?, StreetAddress2 = ?, Town_City = ?, Postcode = ?, TelephoneNo = ?, Email = ? where Haulier_id = ?");
        pstmt.setString(1, hname);
        pstmt.setString(2, hstad1);
        pstmt.setString(3, hstad2);
        pstmt.setString(4, htown);
        pstmt.setString(5, hpostcode);
        pstmt.setInt(6, htelno);
        pstmt.setString(7, hemail);
        pstmt.setInt(8, haulid);
        int i = pstmt.executeUpdate();
        System.out.println("data updated");
        pstmt.close();
        con.close();
        return i;
    }

    private int haulid;
    private int htelno;
    private String hname;
    private String hstad1;
    private String hstad2;
    private String htown;
    private String hpostcode;
    private String hemail;
}