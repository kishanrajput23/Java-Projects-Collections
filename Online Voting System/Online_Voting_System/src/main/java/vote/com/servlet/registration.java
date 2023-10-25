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

public class registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();
		
		
		String f=request.getParameter("fname");
		
		String c=request.getParameter("cardno");
		String cn=request.getParameter("cono");
		String ad=request.getParameter("add");
		String dob=request.getParameter("dob");
		String email=request.getParameter("email");
		String pin=request.getParameter("pin");
		try
		{
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/votingdb","Vaishnavi","Nelavetla@537");
		PreparedStatement ps=con.prepareStatement("insert into register values(?,?,?,?,?,?,?)");
		ps.setString(1,f);
		
		ps.setString(2,c);
		ps.setString(3,cn);
		ps.setString(4,ad);
		ps.setString(5,dob);
		ps.setString(6,email);
		ps.setString(7,pin);
		int i=ps.executeUpdate();
		if(i>0)
		{
			out.print("Successfully your account has been created...PLEASE LOGIN");
			 RequestDispatcher rd=request.getRequestDispatcher("loginpage.html");  
		        rd.include(request,response);
		}
		else
		{
			out.print("Failed account creation try again");
			 RequestDispatcher rd=request.getRequestDispatcher("registration.html");  
		        rd.include(request,response);
		}
			
		}
		catch (Exception e2) {
			out.print("Invalid , Failed account creation try again  "+e2);
			 RequestDispatcher rd=request.getRequestDispatcher("registration.html");  
		        rd.include(request,response);
		}
		
		out.close();
	
}
	protected void service(HttpServletRequest request, HttpServletResponse   response) throws ServletException, IOException 
	{
        doPost(request, response);
	}

}
