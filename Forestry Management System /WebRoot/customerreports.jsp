<%@ page import="java.sql.*" %>
<% System.out.println("In customerreports.jsp"); %>
<% System.out.println("after set custid"); %>

<body bgcolor="skyblue">
<table border="1"  bgcolor="wheet" align="center">
<tr>
<td>CUSTOMER ID</td>
<td>CUSTOMER NAME</td>
<td>STREET ADDRESS1</td>
<td>STREET ADDRESS2</td>
<td>TOWN/CITY</td>
<td>POST CODE</td>
<td>TELEPHONE NUMBER</td>
<td>EMAIL</td>
</tr>
<%
Connection con=dbcon.JDBCConn.getConnection();
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("SELECT * FROM customer");
while(rs.next())
{
%>
<tr>
<td><%=rs.getString(1)%></td>
<td><%=rs.getString(2)%></td>
<td><%=rs.getString(3)%></td>
<td><%=rs.getString(4)%></td>
<td><%=rs.getString(5)%></td>
<td><%=rs.getString(6)%></td>
<td><%=rs.getString(7)%></td>
<td><%=rs.getString(8)%></td>
</tr>
<%}%>
</table><br><br>


</body>

