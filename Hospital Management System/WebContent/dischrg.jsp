<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DISCHARGE WINDOW</title>
</head>
<body background ="compaqblue7vy.jpg">
<body>
<form action="dischrg.jsp" method=post>
<%! String a,str1,b,d,e,abc; %>
<center>
<table border=3>
<tr>
<td>
<h1>DISCHARGE PATIENT</h1>
</td>
</tr>
</table>
<br><br><br><br>
<table border=2>
<tr><td>
ENTER THE PATIENT ID TO DISCHARGE--<input type="text" name="t1" maxlength=10 size=20><BR>
<input type="submit"  name="button1" value="ENTER"><br><br><br><br>
</td>
</tr>
<tr>
<td>
<%
	try{
		a=request.getParameter("button1");
		if(a.equals("ENTER"))
		{	
			str1= request.getParameter("t1");
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection c=DriverManager.getConnection ("jdbc:odbc:abc", "root", "data");
			Statement s= c.createStatement();
			if(str1!="")
			{
				String sq="select * from patient where patient_id="+str1+"";
				ResultSet rs1=s.executeQuery(sq);
				if(rs1.next())
				{	
					out.println("PATIENT ID="+rs1.getString(1)); %><br><%
					out.println("PATIENT NAME="+rs1.getString(2)); %><br><%
					out.println("DATE OF BIRTH="+rs1.getString(3)); %><br><%
					out.println("DOCTOR FEE ="+rs1.getString(4)); %><br><%
					out.println("FATHER'S NAME ="+rs1.getString(5)); %><br><%
					out.println("DEPARTMENT ID="+rs1.getString(6)); %><br><%
					out.println("BLOOD GROUP ="+rs1.getString(7)); %><br><%
					out.println("GENDER ="+rs1.getString(8)); %><br><%
					%><br>
					<h3>ARE YOU SURE YOU WANT TO DISCHARGE PATIENT</h3>
					<input type="submit"  name="button1" value="DISCHARGE">
					<input type="submit"  name="button1" value="HOME" onclick="location.href'home.jsp'">
					</td>
					</tr>
					<%
				}	
				else
				{
					%><script language="javascript">
					alert("INVALID PATIENT ID <%=str1%>..!!!");
					</script>
					<%
				}
			}	
			else
			{
				%><script language="javascript">
				alert("ENTER PATIENT'S ID TO DISCHARGE..!!!");
				</script>
				<%
			}	
		}
		}catch(Exception e){}
%>

<%
try
{
	a=request.getParameter("button1");
	if(a.equals("DISCHARGE"))
	{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection c=DriverManager.getConnection ("jdbc:odbc:abc", "root", "data");
		Statement s= c.createStatement();
		
		String sql="delete from rooms where patient_id="+str1+"";
		//String sq2="update table patient set status='D' where patient_id="+str1+"";
		//s.execute(sq2);
		s.execute(sql);
		%>
		<script language="javascript">
		alert("PATIENT WITH ID <%=str1%> DISCHARGED");
		</script>
		<%
			session.setAttribute("abc",str1);
		%>
		<input type="button"  name="button1" value="GENERATE BILL" onClick="fun()">
		
		<script language="javascript">
		function fun()
		{
		winobj=window.open("bill.jsp","jj","");
		}
		</script>
<%
	}
}catch(Exception e){ }
%>
</table>		
</center>
</form>		
</body>
</html>