package com.javatpoint.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatpoint.beans.AccountantBean;
import com.javatpoint.beans.StudentBean;
import com.javatpoint.dao.AccountantDao;
import com.javatpoint.dao.StudentDao;
@WebServlet("/ViewAccountant")
public class ViewAccountant extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>View Accountant</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='style.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navadmin.html").include(request, response);
		out.println("<div class='container'>");
		out.print("<h1>View Accountant</h1>");
	
		List<AccountantBean> list=AccountantDao.getAllRecords();
		out.println("<table class='table table-bordered table-striped'>");
		out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Password</th><th>address</th><th>contact</th><th>Edit</th><th>Delete</th>");
		for(AccountantBean bean:list){
			out.print("<tr><td>"+bean.getId()+"</td><td>"+bean.getName()+"</td><td>"+bean.getEmail()+"</td><td>"+bean.getPassword()+"</td><td>"+bean.getAddress()+"</td><td>"+bean.getContact()+"</td><td><a href='EditAccountantForm?id="+bean.getId()+"'>Edit</a></td><td><a href='DeleteAccountant?id="+bean.getId()+"'>Delete</a></td></tr>");
		}
		out.println("</table>");
			
		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}
}
