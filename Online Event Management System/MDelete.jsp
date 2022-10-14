<%@ page import="java.io.*,java.util.*" %>
<%@ page import="java.sql.*,javax.sql.*,javax.naming.*" %>
<%@ page session="true" %>
<%	



   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   Connection    con=DriverManager.getConnection("Jdbc:Odbc:shyam","scott","tiger");
   Statement stmt=con.createStatement();
   int count=0;
   String MeetName=request.getParameter("cancel");    

   count=stmt.executeUpdate("delete MeetingTable where Mname='"+MeetName+"'");
	if(count>0){


              out.println("<body bgcolor='yellow'><h1 align='center'>Meeting Deleted Successfully Deleted Successfully!</h1>");

      	       
	}else{
                 out.println("Meeting  was not deleted");  	
	
	}
	%>