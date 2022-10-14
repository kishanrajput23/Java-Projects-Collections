<html>
<%@page import="java.sql.*" %>
<%
   String vsname=request.getParameter("sname");
   String vparent=request.getParameter("parent");
   String vdob=request.getParameter("dob");
   String vmob=request.getParameter("mob");
   String vpreadd=request.getParameter("preadd");
   String vperadd=request.getParameter("peradd");
   String vedu=request.getParameter("edu");
   String vdept=request.getParameter("dept");
   String vadmno=request.getParameter("admno");
   String vssc=request.getParameter("ssc");
   String vinter=request.getParameter("inter");
   String vdoj=request.getParameter("doj");
   String vhtno=request.getParameter("htno");
   String vpwd=request.getParameter("pwd");
   String vrpwd=request.getParameter("rpwd");

  try{
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   Connection    con=DriverManager.getConnection("Jdbc:Odbc:shyam","scott","tiger");
   String vsql="insert into stumaster1 values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
   PreparedStatement ps=con.prepareStatement(vsql);
   ps.setString(1,vsname);
   ps.setString(2,vparent);
   ps.setString(3,vdob);
   ps.setString(4,vmob);
   ps.setString(5,vpreadd);
   ps.setString(6,vperadd);
   ps.setString(7,vedu);
   ps.setString(8,vdept);
   
   ps.setString(9,vadmno);
   ps.setString(10,vssc);
   ps.setString(11,vinter);
   ps.setString(12,vdoj);
   ps.setString(13,vhtno);
   ps.setString(14,vpwd);
   ps.setString(15,vrpwd);
   
   ps.executeUpdate();

    out.println("<body bgcolor='lightyellow'><h3 align='center'>One Record Inserted Successfully!</h3>");

	       out.println("<br><br><center><table border=8 bordercolor=blue><tr><td><h3 align='cener'><a href='AdminHome.html'>Admin Home Page</h3></a></td></tr>");

	       out.println("<br><br><center><tr><td><h3 align='cener'><a href='studreg.html'> Student Registration page</h3></a></td></tr></table></body>");

}catch (Exception e) {

		out.println("SQLException: " + e.getMessage());
               out.println("<h1><a href='studreg.html'> Back To Student Registration </h1></a>>");		
	}

%>

</body>
</html>
 