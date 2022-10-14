<%@ page import="java.sql.*"%>
<%!Connection con;
   Statement st;
   ResultSet rs;
   String sql;
    

%>
<%
String uid=request.getParameter("uids");
String pwd=request.getParameter("pwds");
String type ;
   try
  {
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
  }
catch(ClassNotFoundException e)
   {
    out.println(e.getMessage());
   }

  try
  {
   con=DriverManager.getConnection("Jdbc:Odbc:orads","scott","tiger");
   st=con.createStatement();
   sql="select * from WBMSlogin";
   rs=st.executeQuery(sql);
while(rs.next())
   {
    
  if((uid.equals(rs.getString(1)))&&(pwd.equals( rs.getString(2))))
   { 
   type=rs.getString(6);
   if(type.equals("admin"))
   {    
    response.sendRedirect("Adminpage.html");
   }
   else if(type.equals("faculty"))
   {
    response.sendRedirect("userhme1.html");
   }
}
}

   response.sendRedirect("ReLogin.html");
 
  }   


catch(Exception e)
   {
    out.println(e.getMessage());
   }
%>