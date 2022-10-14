<%@ page import="java.io.*,java.util.*" %>
<%@ page import="java.sql.*,javax.sql.*,javax.naming.*" %>
<%@ page session="true" %>
<%	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Connection con=DriverManager.getConnection("Jdbc:Odbc:orads", "scott", "tiger");
	Statement stmt=con.createStatement();
	String userid=request.getParameter("userid");
	ResultSet rs=stmt.executeQuery("select * from wbmslogin where Userid='"+userid+"'");
	String Uid="";
	String pwd="";
	String mailid="";
	String collid="";
	String dep="";
	String usertype="";
	if(rs.next()){
		Uid=rs.getString(1);
		 pwd=rs.getString(2);
		 mailid=rs.getString(3);
		collid=rs.getString(4);
		 dep=rs.getString(5);
		 usertype=rs.getString(6);
		 session.setAttribute("userid",Uid);
	
%>


<html>
<BODY  topmargin=0>


<table height="15%" width="100%" border=1 bordercolor="yellow" bgcolor=#7777>
<tr><td align="center"><font size=+3 color=white>User Profile Edit </td>

</tr>

</table>


<FORM name="f1" action="Userupdate.jsp">
<table height="75%" width="40%" border=1 align="center"  bordercolor=red><tr><td>
<table height="100%" width="100%" bgcolor="lightyellow" align="center" valign="top" border="0">
	<tr><td colspan=2 align="Left" bgcolor="#006699"><font color="white"><b>Faculty DETAILS:</b></font></td></tr>
	<tr><td align="center">User Name</td><td><input type="text" name="Uid" value="<%=Uid%>"></td></tr>
	<tr><td align="center">Password</td><td><input type="password" name="pwd" value="<%=pwd%>"></td></tr>
	<tr><td align="center">Mail Id</td><td><input type="text" name="mailid" value="<%=mailid%>"></td></tr>
	<tr><td align="center">College Id</td><td><input type="text" name="collid" value="<%=collid%>"></td></tr>
	<tr><td align="center">Department</td><td><input type="text" name="dep" value="<%=dep%>"readonly></td></tr>
	<tr><td align="center">User Type</td><td><input type="usertype" name="usertype" value="<%=usertype%>"></td></tr>
        <tr><td><input type=submit value=UpDate></td></tr>  



</table>
</td></tr><table>
</FORM>

</BODY>
</html>
<%} else{
		out.println("<h1 align='center'> <font color='red'>Please Enter Valid User ID</font></h1>");

	}
	%>