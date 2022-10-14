<%@page import="java.sql.*" %>
<% String uid = request.getParameter("uids");
  String pwd = request.getParameter("pwds");
  String utype = request.getParameter("utype");
  
  
  PreparedStatement pst;
  ResultSet Rs;
 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   Connection con=DriverManager.getConnection("Jdbc:Odbc:orads","scott","tiger");

  try
{
  
		pst = con.prepareStatement("select * from WBMSlogin where USERid=? and pwd=?");
                pst.setString(1,uid);
                pst.setString(2,pwd);
		Rs = pst.executeQuery();

while(Rs.next())
{	session.putValue("UID",uid);
        session.putValue("PWD",pwd);
      if(uid.equalsIgnoreCase("admin"))  
	{
	response.sendRedirect("Adminpage.html");    
     	}
	else
	{
         response.sendRedirect("userhme1.html");    
	} 
	
}
out.println("<br><br><br><br><center><h1> Invalid User : "+uid+" ,"+pwd+"</h1></center>");
			out.println("<p> <center> <a href=login.html> GO TO LOGIN </a> </center>");
}
catch(Exception e){out.println(e.getMessage());}

%>

 


 

