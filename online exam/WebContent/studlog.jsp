<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%@ page language ="java" import="java.sql.*" %>
<html>
<body background="F:\wallies\HD Wallpapers\img36.jpg">
<form name="f1" method="post">
<CENTER>
<BR><BR><BR><BR><BR>
<table cellpadding=8 cellspacing=8 border="10" bgcolor="transparent">
<th bgcolor="transparent" colspan=2>
<font face="Times New Roman" color=LIGHTgrey size=10 >STUDENT LOGIN</FONT><BR></th>

<tr bgcolor="transparent">
<td valign=top> 
<font size=5 face="Times New Roman" color=LIGHTYELLOW>
<b>USER_ID</b>
</font>
<input type="text" name="t1" value="" size=20 maxlength=20></td>
</tr>

<tr bgcolor="transparent">
<td valign=top> 
<font size=5 face="Times New Roman" color=LIGHTYELLOW>
<b>PASSWORD</b>
</font>
<input type="password" name="t2" value="" size=20 maxlength=20></td>
</tr>

<tr bgcolor="transparent">
<td valign=top> 
<input type="submit" name="b1" value="LOGIN">
<input type="button" value="EXIT" onclick="location.href='page1.jsp'">
</tr>


</TABLE>
</CENTER>

<%
String user=request.getParameter("t1");
String pass=request.getParameter("t2");

     try{
    
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:odbc:abc", "scott", "tiger");
     Statement st=con.createStatement();
     ResultSet rs=st.executeQuery("select stud_id,pwd from student");
     while(rs.next())
         {
         String username=rs.getString(1);
         String password=rs.getString(2);
         if(user.equals(username) && pass.equals(password))
             {
 %>
             <jsp:forward page="instructions.jsp" />
  <%       	 }
         
  
     }
     if(rs.isLast()==true)
     {
    	 out.println("Login Failed,Please try Again");
     }
}catch(Exception e1)
{}

%>

</body>
</html>