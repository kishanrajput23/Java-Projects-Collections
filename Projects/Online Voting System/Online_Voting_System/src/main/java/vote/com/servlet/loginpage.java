package vote.com.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	final static  Connection con=DBUtilR.getDBConnection();
	static PreparedStatement ps = null;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();  
		String card=request.getParameter("cardno");
		Integer pin=Integer.parseInt(request.getParameter("pin"));
		
		try {
			if(check(card,pin))
			{
				out.print("Successful Login...You Can Vote Now");
				RequestDispatcher rd=request.getRequestDispatcher("vote.html");
				 rd.include(request,response);
			}	
			else {
				 out.print("Sorry username or password error , Make new account");  
				 RequestDispatcher rd=request.getRequestDispatcher("registration.html");  
			        rd.include(request,response);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	
	
	}
	static boolean check(String card,Integer pin) throws SQLException
	 {
		 boolean r=false;
		 ps=con.prepareStatement("Select * from register where cardno=? and pin=?");
		 ps.setString(1,card);
		 ps.setInt(2,pin);
		 ResultSet rs=ps.executeQuery();
		 r=rs.next();
		 
		 return r;
	 }
	
	static boolean checkvote(String card) throws SQLException
	 {
		 boolean r=false;
		 ps=con.prepareStatement("Select * from vote where cardno=?");
		 ps.setString(1,card);
		 
		 ResultSet rs=ps.executeQuery();
		 r=rs.next();
		 
		 return r;
	 }

}
