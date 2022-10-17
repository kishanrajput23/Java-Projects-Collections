<%@ page import="java.sql.*" %>
<% System.out.println("In customerreports.jsp"); %>
<% System.out.println("after set custid"); %>

<body bgcolor="skyblue">
<table border="1"  bgcolor="wheet" align="center">
<tr>
<td>PRODUCT ID</td>
<td>PRODUCT NAME</td>
<td>PRODUCT DESCRIPTION</td>
</tr>
<%
Connection con=dbcon.JDBCConn.getConnection();
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("SELECT * FROM product");
while(rs.next())
{
%>
<tr>
<td><%=rs.getString(1)%></td>
<td><%=rs.getString(2)%></td>
<td><%=rs.getString(3)%></td>
</tr>
<%}%>
</table><br><br>


</body>

