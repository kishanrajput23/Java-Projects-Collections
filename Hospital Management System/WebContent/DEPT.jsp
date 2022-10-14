<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DEPARTMENT INFORMATION WINDOW</title>
</head>
<body background ="ArtGalleries.jpg" bgproperties="fixed">
<body>
<center><h1>DEPARTMENT INFORMATION</h1>
<form action="DEPT.jsp" method="post" name="f1" >
<%!String a="",b="",d="",e="",f="",g="",h="",i="",j=""; %>
<table BORDER=3><br><br><br>
<tr><td>DEPARTMENT ID<input type="text" name="t1" maxlength=10 size=20><BR>
</td>
<td><h4>DEPARTMENT DETAILS</h4>
</td>
</tr>
<tr>
<td>
<input type="submit"  name="Button1" value="ADD DEPARTMENT"><br><br>
<input type="submit"  name="Button1" value="SEARCH DEPARTMENT PROFILE"><br><br>
<input type="submit"  name="Button1" value="DELETE DEPARTMENT PROFILE"><br><br>
<input type="submit"  name="Button1" value="EDIT DEPARTMENT PROFILE"><br><br>
<%
try
{	a=request.getParameter("Button1"); 
	if(a.equals("SEARCH DEPARTMENT PROFILE"))
	{
	String str1= request.getParameter("t1");
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Connection c=DriverManager.getConnection ("jdbc:odbc:abc", "root", "data");
	Statement s= c.createStatement();
	if(str1!="")
	{	
		String sql2="select * from department where dept_id='"+str1+"'";
		ResultSet r=s.executeQuery(sql2);
		if(r.next())
		{
			j=r.getString(1);
			b=r.getString(2);	
			d=r.getString(3);
			e=r.getString(4);
			f=r.getString(5);
		}
		else
		{	
			%><script language="javascript">
			alert("DEPARTMENT ID=<%=str1%>does not exist in database..!!!");
			</script>
			<%			
		}	
		
	}
	else
	{
		%><script language="javascript">
		alert("ENTER DEPARTMENT ID TO SEARCH..!!!");
		</script>
		<%		
	}
	}
}catch(Exception e) {}
%>

</td>
<td>
DEPARTMENT NAME<input type="text" name="t2" maxlength=10 size=20 value=<%=b%>><BR>
DEPARTMENT DOCTOR<input type="text" name="t3" maxlength=10 size=20 value=<%=d%>><BR>
DEPARTMENT HEAD<input type="text" name="t4" maxlength=10 size=20 value=<%=e%>><BR>
PHONE NO<input type="text" name="t5" maxlength=10 size=20 value=<%=f%>><BR>
</td></tr>
<%
try{
	
	a=request.getParameter("Button1");
	String str1= request.getParameter("t1");
	String str2= request.getParameter("t2");
	String str3= request.getParameter("t3");
	String str4= request.getParameter("t4");
	String str5= request.getParameter("t5");
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Connection c=DriverManager.getConnection ("jdbc:odbc:abc", "root", "data");
	Statement s= c.createStatement();
	if(a.equals("ADD DEPARTMENT PROFILE"))
	{	

	if(str1!=""&&str2!=""&&str3!=""&&str4!=""&&str5!="")
	{	
		String sql="insert into department values("+str1+",'"+str2+"','"+str3+"','"+str4+"',"+str5+")";
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
	else if(a.equals("DELETE DEPARTMENT PROFILE"))
	{
		if(str1!="")
		{
			String sq="select * from department where dept_id="+str1+"";
			ResultSet rs1=s.executeQuery(sq);
			if(rs1.next())
			{	
				
				String sql="delete from department where dept_id="+str1+"";
				s.execute(sql);
				%><script language="javascript">
				alert("PROFILE OF DEPARTMENT WITH ID <%=str1%>DELETED");
				</script>
				<%
			}
			else
			{
				%><script language="javascript">
				alert("INVALID DEPARTMENT ID <%=str1%>..!!!");
				</script>
				<%
			}
		}
		else
		{
			%><script language="javascript">
			alert("ENTER DEPARTMENT'S ID TO DELETE..!!!");
			</script>
			<%	
		}
	}
	else if(a.equals("EDIT DEPARTMENT PROFILE"))
	{
		if(str1!="")
		{
			String sq="select * from department where dept_id="+str1+"";
			ResultSet rs1=s.executeQuery(sq);
			if(rs1.next())
			{	
				String sql="delete from department where dept_id="+str1+"";
				s.execute(sql);
				String sql1="insert into department values("+str1+",'"+str2+"','"+str3+"','"+str4+"',"+str5+")";
				s.execute(sql1);
				%><script language="javascript">
				alert("PROFILE OF DEPARTMENT WITH ID <%=str1%>EDITED");
				</script>
				<%
			}
			else
			{
				%><script language="javascript">
				alert("INVALID DEPARTMENT ID <%=str1%>..!!!");
				</script>
				<%
			}
		}
		else
		{
			%><script language="javascript">
			alert("ENTER DEPARTMENT'S ID TO EDIT..!!!");
			</script>
			<%	
		}
	}	
	}catch(Exception e) {}

%>
</table>	
<h4>DEPARTMENT PROFILE TABLE</h4>
<table cellspacing=3 cellpadding=5 border="2" >

<th colspan=1 align=center>DEPT ID</th>
<th colspan=1 align=center>DEPT NAME</th>
<th colspan=1 align=center>DEPT DOCTOR</th>
<th colspan=1 align=center>DEPT HEAD</th>
<th colspan=1 align=center>DEPT PHONE</th>
<%
try
{	
	String str1= request.getParameter("t1");
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Connection c=DriverManager.getConnection ("jdbc:odbc:abc", "root", "data");
	Statement s= c.createStatement();
	String q="select * from department";
	ResultSet rs9=s.executeQuery(q);
	while(rs9.next())
	{%><tr>
	
	<%
		for (int i=1; i<=5; i++)
		{
			out.println( "<td > " +  rs9.getString (i) );
			
		}
	}%></tr><%
}catch(Exception e) {}
%>
</table>

	
</form>
<input type="button" name="bttn" value="HOME" onclick="location.href='home.jsp'">
</center>
</body>
</html>