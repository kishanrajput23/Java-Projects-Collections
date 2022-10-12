<jsp:useBean id="user"  scope="session"  class="obs.User"/>
<%@page import="java.sql.*"%>

<html>
<style>
a.topic {font:700 11pt verdana;color:white}
td {font:10pt verdana}
th {font:700 10pt verdana;background-color:green;color:white}
</style>

<body bgcolor="beige">
<h1>Order Items </h1>



<%
  String ordid = request.getParameter("ordid");
  String status = request.getParameter("status");

  String  cmd = "select oi.isbn,title, oi.price,qty, oi.price * qty amount  from orderitem oi, books b where b.isbn = oi.isbn and ordid = " + ordid;
   
   
  Connection con = user.getConnection();
  Statement st = con.createStatement();

  ResultSet rs = st.executeQuery(cmd);

%>

<p>


<table width="100%" cellpadding=2 border=1>
<tr>
<th> ISBN
<th> Title
<th> Price
<th> Quantity
<th> Amount
</tr>

<%
   while ( rs.next())
   {
%>

<tr>
<td> <%=rs.getInt(1)%>
<td> <%= rs.getString(2)%>
<td> <%= rs.getInt(3)%>
<td> <%= rs.getString(4)%>
<td> <%= rs.getString(5)%>
</tr>

<%
  }

  rs.close();
  st.close();
  con.close();

%>

  
</table>

<p>
<%
  if  ( status.equals("n")) 
  {
%>

<a href="deleteorder.jsp?ordid=<%=ordid%>">Cancel This Order</a>
&nbsp;
&nbsp;
<% 
  
  
  }
%>



<a href="javascript:history.back()">Back </a>
  





  