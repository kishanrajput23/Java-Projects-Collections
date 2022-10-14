<html>
<%@page import="java.sql.*" %>
<%
   
String Mname=request.getParameter("Mname");
String Mdescrip=request.getParameter("Mdescrip");	
String Mtype=request.getParameter("Mtype");		
String Stimeh=request.getParameter("Stimeh");		
String Stimem=request.getParameter("Stimem");          
String StimeAMPM=request.getParameter("StimeAMPM");	
String DurationH=request.getParameter("DurationH");	
String Durationm=request.getParameter("Durationm");	
String Sday=request.getParameter("Sday");		
String SMonth=request.getParameter("SMonth");		
String Syear=request.getParameter("Syear");		
String Moptions=request.getParameter("Moptions");	
String Nofpat=request.getParameter("Nofpat");		
String pwd=request.getParameter("pwd");		
String Collegeid=request.getParameter("Collegeid");	
String Emailid=request.getParameter("Emailid");		



  try{
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   Connection con=DriverManager.getConnection("Jdbc:Odbc:orads","scott","tiger");
   String vsql="insert into  MeetingTable values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
   PreparedStatement ps=con.prepareStatement(vsql);
   ps.setString(1,Mname);
   ps.setString(2,Mdescrip);
   ps.setString(3,Mtype);
   ps.setString(4,Stimeh);
   ps.setString(5,Stimem);
   ps.setString(6,StimeAMPM);
   ps.setString(7,DurationH);
   ps.setString(8,Durationm);
   ps.setString(9,Sday);
   ps.setString(10,SMonth);
   ps.setString(11,Syear);
   ps.setString(12,Moptions);
   ps.setString(13,Nofpat);
   ps.setString(14,pwd);
   ps.setString(15,Collegeid);
   ps.setString(16,Emailid);
   
   ps.executeUpdate();

    out.println("<body bgcolor='lightyellow'><h3 align='center'><h1>Meeting Scheduled Successfully</h1>");

	       
}catch (Exception e) {

		out.println("SQLException: " + e.getMessage());
               
	}

%>

</body>
</html>
 