<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
ENTER DOCTOR ID TO EDIT&nbsp;<input type="text" name="t1" maxlength=10 size=20><BR>
<%
int k=0;
try{
	String str1= request.getParameter("t1");
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Connection c=DriverManager.getConnection ("jdbc:odbc:abc", "root", "data");
	Statement s= c.createStatement();
	if(str1!="")
	{	
	String sql="select * from doctor where doc_id="+str1+")";
	s.execute(sql);
	out.println ("Insert Successful");
	k=1;
	}
	}catch(Exception e) { out.println(e); }

%>
DOCTOR NAME<input type="text" name="t2" maxlength=10 size=20><BR>
DOCTOR EDUQUALIFICATION<input type="text" name="t3" maxlength=10 size=20><BR>
DATE OF BIRTH<input type="text" name="t4" maxlength=10 size=20><BR>
FATHER'S NAME<input type="text" name="t5" maxlength=10 size=20><BR>
PHONE NO<input type="text" name="t6" maxlength=10 size=20><BR>
SALARY<input type="text" name="t7" maxlength=10 size=20><BR>
EMAIL ID<input type="text" name="t8" maxlength=10 size=20><BR>
<input type="submit"  name="Button1" value="adddoc" style="position:absolute;font-family:Arial;font-size:13px;" >
</body>
</html>