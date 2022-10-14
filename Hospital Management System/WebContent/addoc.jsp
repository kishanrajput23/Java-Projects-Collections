<%@  page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DOCTORS INFORMATION WINDOW</title>
</head>
<body background="Hospital main entrance-blue sky.jpg" bgproperties="fixed">
<center>
<table border=3 width=500>
<tr><td>
<h1>DOCTOR PROFILE WINDOW</h1>
</td></tr>
</table>
<br><br><br>
<table border=5 width=800>
<tr>
<td>
<form action="addoc.jsp" method=post>
<%!String a="",b="",d="",e="",f="",g="",h="",i="",j=""; %>
<table BORDER=3 >
<br><br><br>
<tr><td>DOCTOR ID<input type="text" name="t1" maxlength=10 size=20><BR>
</td>
<td><h4>DOCTOR DETAILS</h4>
</td>
</tr>
<tr>
<td>
<input type="submit"  name="Button1" value="ADD DOCTOR PROFILE"><br><br>
<input type="submit"  name="Button1" value="SEARCH DOCTOR PROFILE"><br><br>
<input type="submit"  name="Button1" value="DELETE DOCTOR PROFILE"><br><br>
<input type="submit"  name="Button1" value="EDIT DOCTOR PROFILE"><br><br>
<%
try
{	a=request.getParameter("Button1"); 
	if(a.equals("SEARCH DOCTOR PROFILE"))
	{
	String str1= request.getParameter("t1");
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Connection c=DriverManager.getConnection ("jdbc:odbc:abc", "root", "data");
	Statement s= c.createStatement();
	if(str1!="")
	{	
		String sql2="select * from doctor where doc_id='"+str1+"'";
		ResultSet r=s.executeQuery(sql2);
		if(r.next())
		{
			j=r.getString(1);
			b=r.getString(2);	
			d=r.getString(3);
			e=r.getString(4);
			f=r.getString(5);
			g=r.getString(6);
			h=r.getString(7);
			i=r.getString(8);
		}
		else
		{	
			%><script language="javascript">
			alert("DOCTOR ID=<%=str1%>does not exist in database..!!!");
			</script>
			<%			
		}	
		
	}
	else
	{
		%><script language="javascript">
		alert("ENTER DOCTOR ID TO SEARCH..!!!");
		</script>
		<%		
	}
	}
}catch(Exception e) {}
%>

</td>
<td>
<br>
<br>
DOCTOR NAME<input type="text" name="t2" maxlength=10 size=20 value=<%=b%>><BR>
DOCTOR EDUQUALIFICATION<input type="text" name="t3" maxlength=10 size=20 value=<%=d%>><BR>
DATE OF BIRTH<input type="text" name="t4" maxlength=10 size=20 value=<%=e%>><BR>
SALARY<input type="text" name="t5" maxlength=10 size=20 value=<%=f%>><BR>
FATHER'S NAME<input type="text" name="t6" maxlength=10 size=20 value=<%=g%>><BR>
EMAIL ID<input type="text" name="t7" maxlength=10 size=20 value=<%=h%>><BR>
DEPARTMENT ID<input type="text" name="t8" maxlength=10 size=20 value=<%=i%>><BR>
</td>


</tr>
<%
try{
	
	a=request.getParameter("Button1");
	String str1= request.getParameter("t1");
	String str2= request.getParameter("t2");
	String str3= request.getParameter("t3");
	String str4= request.getParameter("t4");
	String str5= request.getParameter("t5");
	String str6= request.getParameter("t6");
	String str7= request.getParameter("t7");
	String str8= request.getParameter("t8");
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Connection c=DriverManager.getConnection ("jdbc:odbc:abc", "root", "data");
	Statement s= c.createStatement();
	if(a.equals("ADD DOCTOR PROFILE"))
	{	

	if(str1!=""&&str2!=""&&str3!=""&&str4!=""&&str5!=""&&str6!=""&&str7!=""&&str8!="")
	{	
		String sql="insert into doctor values("+str1+",'"+str2+"','"+str3+"','"+str4+"',"+str5+",'"+str6+"','"+str7+"',"+str8+")";
		out.println(sql);
		s.execute(sql);
		%><script language="javascript">
		alert("INSERT SUCESSFUL");
		</script>
		<%
	}
	else
	{
		%><script language="javascript">
		alert("ENTER COMPLETE DETAILS..!!!");
		</script>
		<%		
	}
	}
	else if(a.equals("DELETE DOCTOR PROFILE"))
	{
		if(str1!="")
		{
			String sq="select * from doctor where doc_id="+str1+"";
			ResultSet rs1=s.executeQuery(sq);
			if(rs1.next())
			{	
				
				String sql="delete from doctor where doc_id="+str1+"";
				s.execute(sql);
				%><script language="javascript">
				alert("PROFILE OF DOCTOR WITH ID <%=str1%>DELETED");
				</script>
				<%
			}
			else
			{
				%><script language="javascript">
				alert("INVALID DOCTOR ID <%=str1%>..!!!");
				</script>
				<%
			}
		}
		else
		{
			%><script language="javascript">
			alert("ENTER DOCTOR'S ID TO DELETE..!!!");
			</script>
			<%	
		}
	}
	else if(a.equals("EDIT DOCTOR PROFILE"))
	{
		if(str1!="")
		{
			String sq="select * from doctor where doc_id="+str1+"";
			ResultSet rs1=s.executeQuery(sq);
			if(rs1.next())
			{	
				String sql="delete from doctor where doc_id="+str1+"";
				s.execute(sql);
				String sql1="insert into doctor values("+str1+",'"+str2+"','"+str3+"','"+str4+"',"+str5+",'"+str6+"','"+str7+"',"+str8+")";
				s.execute(sql1);
				%><script language="javascript">
				alert("PROFILE OF DOCTOR WITH ID <%=str1%>EDITED");
				</script>
				<%
			}
			else
			{
				%><script language="javascript">
				alert("INVALID DOCTOR ID <%=str1%>..!!!");
				</script>
				<%
			}
		}
		else
		{
			%><script language="javascript">
			alert("ENTER DOCTOR'S ID TO EDIT..!!!");
			</script>
			<%	
		}
	}
	}catch(Exception e) {}

%>

</table>
</form>
<input type="button" name="bttn" value="HOME" onclick="location.href='home.jsp'">
</td>
</tr>
</table>
</center>


</body>
</html>
