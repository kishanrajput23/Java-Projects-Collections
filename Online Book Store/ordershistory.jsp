<jsp:useBean id="user"  scope="session"  class="obs.User"/>
<%@page import="java.sql.*"%>

<html>
<style>
a.topic {font:700 11pt verdana;color:white}
td {font:10pt verdana}
th {font:700 10pt verdana;background-color:green;color:white}
</style>

<body bgcolor="beige">
<h1>Orders History </h1>

<div style="background-color:green}">

<table width="100%">

<tr align="center">
<td>
<a class="topic" href="ordershistory.jsp?type=a">All Orders </a>
<td>
<a class="topic" href="ordershistory.jsp?type=n">New Orders </a>
<td>
<a class="topic" href="ordershistory.jsp?type=p">Processed Orders</a>
<td>
<a class="topic" href="ordershistory.jsp?type=d">Dispatched Orders</a>
<td>
<a class="topic" href="ordershistory.jsp?type=c">Completed Orders </a>
</tr>
</table>
</div>





<%
  String type = request.getParameter("type");
  String  cmd = "select ordid, orddate, totamt,decode(status,'n','New','p','Processed','d','Dispatched','Completed') textstatus,status from orders where userid = " + user.getUserid();
   
  if ( type != null)
  {

  if ( type.equals("n"))
     cmd += " and status = 'n'";
  else
    if ( type.equals("p"))
      cmd += " and status = 'p'";
  else
    if ( type.equals("d"))
      cmd += " and status = 'd'";
    else
      if ( type.equals("c"))
         cmd +=  " and status = 'c'";

  }

  
  Connection con = user.getConnection();
  Statement st = con.createStatement();

  ResultSet rs = st.executeQuery(cmd);

%>

<p>


<table width="100%" cellpadding=2 border=1>
<tr>
<th> Order Id
<th> Order Date
<th> Total Amount
<th> Status
</tr>

<%
   while ( rs.next())
   {
%>

<tr>
<td> <a href="orderitems.jsp?ordid=<%=rs.getInt(1)%>&status=<%=rs.getString(5)%>"> <%=rs.getInt(1)%> </a>
<td> <%= rs.getString(2)%>
<td> <%= rs.getInt(3)%>
<td> <%= rs.getString(4)%>
</tr>

<%
  }

  rs.close();
  st.close();
  con.close();

%>

  
</table>

  





  