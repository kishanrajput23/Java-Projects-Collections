<%@ page language="java" import="java.sql.*" %>

<body bgcolor="#d3d2d1">
<%
   try{
        String uid=request.getParameter("cancel");
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                Connection con=DriverManager.getConnection("Jdbc:Odbc:orads","scott","tiger");
             //    ----- Connection Established ------

         PreparedStatement pst=con.prepareStatement("select Mname from MeetingTable where Mname=?");
                pst.setString(1,uid);
         ResultSet rs=pst.executeQuery();
         if(rs.next())
         {
               
                pst=con.prepareStatement("delete from MeetingTable where Mname=?");
                        pst.setString(1,uid);
                if((pst.executeUpdate()) > 0)
                {
                        out.println("<br><br><br><br><center><h1>    "+uid+" meeting is cancelled.  </h1></center> ");
                }
                else
                {
                        out.println("<br><br><br><br><center><h1>    "+uid+" CANNOT CANCEL THE MEETING. </h1></center>  ");
                }
         }
         else
         {
                        out.println("<br><br><br><br><center><h1>    "+uid+" meeting is not scheduled.  </h1></center> ");
         }   
       }catch(Exception e)
       {
          out.println(e);
       }
%>

<p>
<center>
        <a href="cancel meetings.html"> BACK </a>
</center>

</body>


