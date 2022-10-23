<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="F:\wallies\HD Wallpapers\img36.jpg">

 

<font face="Times New Roman" color=LIGHTYELLOW size=5 >
<TABLE border=10 align=center>
<th bgcolor="transparent" colspan=2>
<font size=10 face="Times New Roman" color=LIGHTgrey>INSTRUCTIONS </font>
<br>
</th>


<%


     try{
    
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:odbc:abc", "scott", "tiger");
     Statement st=con.createStatement();
     ResultSet rs=st.executeQuery("select inst from rule");
     while(rs.next())
         {
  %>
<tr><td> 
<% 
    	 out.println(  rs.getString (1));
%>
</tr>
 <%   	
 		}
}catch(Exception e1)
{}


%>

</TABLE>
</font>
<center>
<input type="button" value="START" onclick="location.href='exam.jsp'"><br><BR>
</center>
</body>
</html>