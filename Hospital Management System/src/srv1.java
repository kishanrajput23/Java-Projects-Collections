

import java.sql.Connection;
import java.sql.DriverManager;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class for Servlet: srv1
 *
 */
 public class srv1 extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public srv1() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		try{
			Class.forName ("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection c= DriverManager.getConnection ("jdbc:odbc:abc", "root", "root");
			Statement s= c.createStatement();
			String sql="select * from department where ";
			s.execute (sql);
			out.println ("Insert Successful");
			}catch(Exception e) {  }

		// TODO Auto-generated method stub
		
	}   	  	    
}