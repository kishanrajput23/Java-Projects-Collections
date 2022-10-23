<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body background="F:\wallies\HD Wallpapers\img36.jpg">
<form action="studentregistration.jsp" method=post>
<center>
<table cellpadding=8 cellspacing=8 border="10" bgcolor="transparent">
<BR><BR><BR><BR>
<th bgcolor="transparent" colspan=2>
<font size=10 face="Times New Roman" color=LIGHTgrey>STUDENT REGISTRATION </font>
<br>
</th>
 
<tr bgcolor="transparent">
<td valign=top> 
<font size=5 face="Times New Roman" color=LIGHTYELLOW>
<b>NAME</b>
</font>
<input type="text" name="t1" value=""  id="txt1" size=20 maxlength=20></td>
<td valign=top> 
<font size=5 face="Times New Roman" color=LIGHTYELLOW>
<b>STUDENT_ID</b>
</font>
<input type="text" name="t2" value="" size=20 maxlength=20></td>
</tr>

<tr bgcolor="transparent">
<td valign=top> 
<font size=5 face="Times New Roman" color=LIGHTYELLOW>
<b>CONTACT NO.</b>
</font>
<input type="text" name="t3" value="" size=20 maxlength=10></td>
<td valign=top> 
<font size=5 face="Times New Roman" color=LIGHTYELLOW>
<b>PASSWORD</b>
</font>
<input type="text" name="t4" value="" size=20 maxlength=20></td>


<tr bgcolor="transparent">
<td align=center colspan=2>
<input type="SUBMIT" value="SUBMIT">


<%
String name=request.getParameter("t1");
String id=request.getParameter("t2");
String phone=request.getParameter("t3");
String pwd=request.getParameter("t4");

if(!(name==" " && id==" "  && phone==" "  && pwd== " "))
{


     try{
    
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:odbc:abc", "scott", "tiger");
     Statement st=con.createStatement();
    st.executeQuery("insert into student values("+id+",'"+name+"',"+phone+",'"+pwd+"')");
    out.println ("Insert Successful");

}catch(Exception e1)
{
}
}
%>
<input type="submit" value="SEARCH" >

<%
if(!( id==" " ))
{


     try{
    
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:odbc:abc", "scott", "tiger");
     Statement st=con.createStatement();
     ResultSet rs=st.executeQuery("select * from student");
    while(rs.next())
         {
         String username=rs.getString(1);




         if(id.equals(username) )
             {
        	 %>

        	 <input type="text" name="t3" value="<%= username %>" size=20 maxlength=20></td>
        	 <%
        	 }
         
  
     }
     if(rs.isLast()==true)
     {
    	 out.println("Login Failed,Please try Again");
     }

}catch(Exception e1)
{
}
}

%>
<input type="SUBMIT" value="DELETE" >
<%
id=request.getParameter("t2");
if(!(id==" "))
{


     try{
    
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:odbc:abc", "scott", "tiger");
     Statement st=con.createStatement();
    String query="delete from student where stud_id="+id;
     st.executeUpdate(query);
    
}catch(Exception e1)
{
}
}
%>



<input type="SUBMIT" value="UPDATE">
<%
name=request.getParameter("t1");
id=request.getParameter("t2");
phone=request.getParameter("t3");
pwd=request.getParameter("t4");

if(!(name==" " && id==" "  && phone==" "  && pwd== " "))
{


     try{
    
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:odbc:abc", "scott", "tiger");
     Statement st=con.createStatement();
    String query="update student set stud_id="+id+",stud_name='"+name+"',phone="+phone+",pwd='"+pwd+"'where stud_id="+id;
     st.executeUpdate(query);
    
}catch(Exception e1)
{
}
}
%>

<input type="button" value="   EXIT     " onclick="location.href='page1.jsp'">

</tr>

</table>
</center>
 </form>
</body>
</html>
