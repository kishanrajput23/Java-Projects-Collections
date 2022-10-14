<%@ page language="java" import="java.sql.*" %>

<body bgcolor="#FFFFE0">
<%
   try{
        String uid=request.getParameter("uid");
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                Connection con=DriverManager.getConnection("Jdbc:Odbc:orads","scott","tiger");
             //    ----- Connection Established ------

         PreparedStatement pst=con.prepareStatement("select userid from wbmslogin where userid=?");
                pst.setString(1,uid);
         ResultSet rs=pst.executeQuery();
         if(rs.next())
         {
               
                pst=con.prepareStatement("delete from wbmslogin where userid=?");
                        pst.setString(1,uid);
                if((pst.executeUpdate()) > 0)
                {
                        out.println("<br><br><br><br><center><h1>   User "+uid+" User deleted.  </h1></center> ");
                }
                else
                {
                        out.println("<br><br><br><br><center><h1>   User "+uid+" Can't be Deleted from Login. </h1></center>  ");
                }
         }
         else
         {
                        out.println("<br><br><br><br><center><h1>   User "+uid+" Does not Exist.  </h1></center> ");
         }   
       }catch(Exception e)
       {
          out.println(e);
       }
%>

<p>
<center>
        <a href="DELETE ACCOUNT.html"> Back </a>
</center>

</body>


