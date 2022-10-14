<%@ page isThreadSafe="true" %>
<!--%@ page errorPage="errorpage.jsp" %-->
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="java.sql.*,javax.sql.*,javax.naming.*" %>
<%@ page session="true" %>
<%	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Connection con=DriverManager.getConnection("Jdbc:Odbc:orads", "scott", "tiger");
				Statement stmt=con.createStatement();			
	String Uid=request.getParameter("Uid");
	String pwd=request.getParameter("pwd");
	String mailid=request.getParameter("mailid");
	String collid=request.getParameter("collid");
	String dep=request.getParameter("dep");
	String usertype=request.getParameter("usertype");
				
	String str="update wbmslogin set  userid='"+Uid+"',pwd='"+pwd+"',mailid='"+mailid+"',collid='"+collid+"',dept='"+dep+"',usertype='"+usertype+"' where userid='"+Uid+"'";
	stmt.executeUpdate(str);
        con.commit(); 

		out.println("<body bgcolor='yellow'><h1 align='center'>One Record Updated  Successfully!</h1>");



%>