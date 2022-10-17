// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 9/18/2008 6:08:43 PM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   OrdersBean.java

package beans;

import dbcon.JDBCConn;
//import java.io.PrintStream;
import java.sql.*;

public class OrdersBean
{

    public OrdersBean()
    {
    }

    public int getCustid()
    {
        return custid;
    }

    public void setCustid(int custid)
    {
        this.custid = custid;
    }

    public String getDeliverydate()
    {
        return deliverydate;
    }

    public void setDeliverydate(String deliverydate)
    {
        this.deliverydate = deliverydate;
    }

    public int getHaulid()
    {
        return haulid;
    }

    public void setHaulid(int haulid)
    {
        this.haulid = haulid;
    }

    public int getOrderno()
    {
        return orderno;
    }

    public void setOrderno(int orderno)
    {
        this.orderno = orderno;
    }

    public int getProdid()
    {
        return prodid;
    }

    public void setProdid(int prodid)
    {
        this.prodid = prodid;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public int insert()
        throws Exception
    { 
    	
        Connection con = JDBCConn.getConnection();
        PreparedStatement pstmt = con.prepareStatement("insert into orders values(?,?,?,?,?,?)");
        pstmt.setInt(1, orderno);
        pstmt.setInt(2, custid);
        pstmt.setInt(3, prodid);
        pstmt.setInt(4, haulid);
        pstmt.setString(5, deliverydate);
        pstmt.setInt(6, quantity);
        try
        {
        int i = pstmt.executeUpdate();
        System.out.println("data inserted");
        pstmt.close();
        con.close();
        return i;
        }
        catch(Exception e)
        {
        	return 0;
        }
    }

    public void select()
        throws Exception
    {
        Connection con = JDBCConn.getConnection();
        System.out.println("In select of Case");
        PreparedStatement pstmt = con.prepareStatement("select * from orders where orderno=?");
        System.out.println("after pstmt");
        pstmt.setInt(1, orderno);
        ResultSet rs = pstmt.executeQuery();
        System.out.println("entered into case java");
        for(; rs.next(); System.out.println("....data retrieved...."))
        {
            orderno = rs.getInt(1);
            custid = rs.getInt(2);
            prodid = rs.getInt(3);
            haulid = rs.getInt(4);
            deliverydate = rs.getString(5);
            quantity = rs.getInt(6);
            System.out.println(orderno);
            System.out.println(deliverydate);
        }

    }

    public int delete(int articleid)
        throws Exception
    {
        Connection con = JDBCConn.getConnection();
        String query = "DELETE  FROM orders WHERE orderno=" + orderno;
        Statement stmt = con.createStatement();
        int i = stmt.executeUpdate(query);
        return i;
    }

    private int orderno;
    private int custid;
    private int haulid;
    private int prodid;
    private int quantity;
    private String deliverydate;
}