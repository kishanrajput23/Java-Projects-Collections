<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BILL WINDOW</title>
</head>
<body background="foliage-swirls-000145-light-sky-blue.jpg">
<center>
<h1>FORTIS HOSPITAL</h1>
<h3>BILL RECEIPT</h3>
<%! String abc,a,b,d,e,g,h,i,j,k,z; int m1=0,f=0,l=0;%>
<%
	String b=(String)session.getAttribute("abc");
%>
<%
try
{
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Connection c=DriverManager.getConnection ("jdbc:odbc:abc", "root", "data");
	Statement s= c.createStatement();
	String sq="select * from patient where patient_id="+b;
	ResultSet rs=s.executeQuery(sq);
	if(rs.next())
	{
	z=rs.getString(1);
	d=rs.getString(2);	
	e=rs.getString(3);
	f=Integer.parseInt(rs.getString(4));
	g=rs.getString(5);
	h=rs.getString(6);
	i=rs.getString(7);
	j=rs.getString(8);l=f+500+3000;
	m1=3000;
	}
	
}catch(Exception e){ out.println(e);}	
%>
<table border=2>
<tr>
<td colspan=7>
<h2>PATIENT DETAILS</h2>

</td>
</tr>
<tr>
<td>PATIENT ID<br><%=z%></td>
<td>PATIENT NAME<br><%=d%></td>
<td>DATE OF BIRTH<br><%=e %></td>
<td>FATHER's NAME<br><%=g %></td>
<td>BLOOD GROUP<br><%=h %></td>
<td>DEPARTMENT ID<br><%=i %></td>
<td>SEX<br><%=j %></td>
</tr>
<tr>
<td colspan=7>
<h2>BILL DETAILS</h2>
</td></tr>
<tr><td colspan=7 ALIGN=left>
<pre>
DOCTOR FEE=<%=f%><br><br>
ACCOMODATION CHARGES=<%=m1%><br><br>
MAINTAINENCE FEE= Rs500<br><br>
TOTAL FEES=<%=l%>      



ACCOUNTS MANAGER												
</pre>
</td>



</tr>



</table>
</center>
</body>
</html>