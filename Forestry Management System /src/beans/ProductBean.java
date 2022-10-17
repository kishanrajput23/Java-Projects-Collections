// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 9/18/2008 6:09:01 PM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ProductBean.java

package beans;

import dbcon.JDBCConn;
//import java.io.PrintStream;
import java.sql.*;

public class ProductBean
{

    public ProductBean()
    {
    }

    public String getPdesc()
    {
        return pdesc;
    }

    public void setPdesc(String pdesc)
    {
        this.pdesc = pdesc;
    }

    public String getPname()
    {
        return pname;
    }

    public void setPname(String pname)
    {
        this.pname = pname;
    }

    public int getProdid()
    {
        return prodid;
    }

    public void setProdid(int prodid)
    {
        this.prodid = prodid;
    }

    public int insert()
        throws Exception
    {
        Connection con = JDBCConn.getConnection();
        PreparedStatement pstmt = con.prepareStatement("insert into product values(?,?,?)");
        pstmt.setInt(1, prodid);
        pstmt.setString(2, pname);
        pstmt.setString(3, pdesc);
        try
        {
        int i = pstmt.executeUpdate();
        System.out.println("data inserted");
        pstmt.close();
        con.close();
        return i;}
        catch(Exception e){
        	return 0;
        }
    }

    public void select()
        throws Exception
    {
        Connection con = JDBCConn.getConnection();
        System.out.println("In select of Case");
        PreparedStatement pstmt = con.prepareStatement("select * from product where product_id=?");
        System.out.println("after pstmt");
        pstmt.setInt(1, prodid);
       System.out.println("before");
        ResultSet rs = pstmt.executeQuery();
        System.out.println("after");
       
        System.out.println("entered into case java");
        for(; rs.next(); System.out.println("....data retrieved...."))
        {
            prodid = rs.getInt(1);
            pname = rs.getString(2);
            pdesc = rs.getString(3);
            System.out.println(prodid);
            System.out.println(pname);
        }

    }

    public int delete(int articleid)
        throws Exception
    {
        Connection con = JDBCConn.getConnection();
        String query = "DELETE  FROM product WHERE product_id=" + prodid;
        Statement stmt = con.createStatement();
        int i = stmt.executeUpdate(query);
        return i;
    }

    public int Update()
        throws Exception
    {
        Connection con = JDBCConn.getConnection();
        PreparedStatement pstmt = con.prepareStatement("Update  Product set Product_Name = ?, Product_Description = ? where Product_id = ?");
        pstmt.setString(1, pname);
        pstmt.setString(2, pdesc);
        pstmt.setInt(3, prodid);
        int i = pstmt.executeUpdate();
        System.out.println("data inserted");
        pstmt.close();
        con.close();
        return i;
    }

    private int prodid;
    private String pname;
    private String pdesc;
}