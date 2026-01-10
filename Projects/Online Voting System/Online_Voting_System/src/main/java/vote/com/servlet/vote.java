package vote.com.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class vote extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    final static Connection con=DBUtilR.getDBConnection();
    static PreparedStatement ps = null;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();
		
		
		String f=request.getParameter("cardno");
		String l=request.getParameter("party");
		try
		{
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/votingdb","Vaishnavi","Nelavetla@537");

		if(checkLogin(f))
		{
			
		ps=con.prepareStatement("insert into vote values(?,?)");
		ps.setString(1,f);
		ps.setString(2,l);
		int i=ps.executeUpdate();
		if(i>0)
		{
			out.print("Your Vote has been submitted successfully...");
			 RequestDispatcher rd=request.getRequestDispatcher("thankyou.html");  
		        rd.include(request,response);
		}
		else
		{
			out.print("Failed to submit vote, try again");
			 RequestDispatcher rd=request.getRequestDispatcher("vote.html");  
		        rd.include(request,response);
		}
		}
		else
		{
			out.print("Please enter correct card number");
			RequestDispatcher rd=request.getRequestDispatcher("vote.html");  
	        rd.include(request,response);
		}
		}
		catch (SQLIntegrityConstraintViolationException e2) {
			out.print("Please select any party");
			 RequestDispatcher rd=request.getRequestDispatcher("vote.html");  
		        rd.include(request,response);
		}
		catch(Exception e)
		{
			out.print(" " +e);
			RequestDispatcher rd=request.getRequestDispatcher("vote.html");  
	        rd.include(request,response);
		}
		out.close();
	
		
}
	protected void service(HttpServletRequest request, HttpServletResponse   response) throws ServletException, IOException {
        doPost(request, response);
}
	


static boolean checkLogin(String card) throws SQLException
{
 boolean r=false;
 ps=con.prepareStatement("Select * from register where cardno = ?");
 ps.setString(1,card);
 
 ResultSet rs=ps.executeQuery();
 r=rs.next();
 
 return r;
}
}
