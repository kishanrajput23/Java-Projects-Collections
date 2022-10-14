<%@ page language = "java" import= "java.sql.*" %>

<BODY BGCOLOR="#d3d2d1">
<br><br>
<%
     try{
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   Connection con=DriverManager.getConnection("Jdbc:Odbc:orads","scott","tiger");

	String old_pwd=(String)request.getParameter("old_pwd");
	String new_pwd=(String)request.getParameter("new_pwd");

	String uid="Admin";
	String sql="select pwd from wbmslogin where userid=? and pwd=? ";	

	PreparedStatement pst=con.prepareStatement(sql);
	pst.setString(1,uid);
	pst.setString(2,old_pwd);

	//System.out.println(sql);

	ResultSet rs=pst.executeQuery();
	if(rs.next()==false)
	{
%>
	       <center>
			<h1 align=center> Invalid password <br> Please enter Correct Password </h1>
		<a href="ChangeAdminPwd.html"> <h2>Back to Change Password </h2></a>
	      </center>
<%
	}
	else
	{
		sql="update wbmslogin set pwd=? where userid=? ";
		pst=con.prepareStatement(sql);
		     pst.setString(1,new_pwd);
		     pst.setString(2,uid);
		int num=pst.executeUpdate();
	if(num>0)
	{
%>
			<h1 align=center> Password changed Successfully <br> Now you have to use new Password </h1>
<%
			session.putValue("PWD",new_pwd);
	}
	else
	{
%>
	       <center>
	     	<h1> Password Not Changed </h1>   <p>
		<a href="change password.html"> <h2>Back to Change Password </h2></a>
	      </center>
<%
	}
	}
	}catch(Exception e)
	       {
		out.println(e);
	       }
%>
</BODY>


