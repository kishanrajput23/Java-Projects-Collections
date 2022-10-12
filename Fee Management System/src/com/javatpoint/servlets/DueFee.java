package com.javatpoint.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatpoint.beans.StudentBean;
import com.javatpoint.dao.StudentDao;
@WebServlet("/DueFee")
public class DueFee extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>View Student</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='style.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navaccountant.html").include(request, response);
		out.println("<div class='container'>");
		
		out.print("<h1>Due Fee</h1>");
	
	
		List<StudentBean> list=StudentDao.getDues();
		out.println("<table class='table table-bordered table-striped'>");
		out.print("<tr><th>Rollno</th><th>Name</th><th>Email</th><th>Sex</th><th>Course</th><th>Fee</th><th>paid</th><th>due</th><th>address</th><th>contact</th><th>Edit</th><th>Delete</th>");
		for(StudentBean bean:list){
			out.print("<tr><td>"+bean.getRollno()+"</td><td>"+bean.getName()+"</td><td>"+bean.getEmail()+"</td><td>"+bean.getSex()+"</td><td>"+bean.getCourse()+"</td><td>"+bean.getFee()+"</td><td>"+bean.getPaid()+"</td><td>"+bean.getDue()+"</td><td>"+bean.getAddress()+"</td><td>"+bean.getContact()+"</td><td><a href='EditStudentForm?rollno="+bean.getRollno()+"'>Edit</a></td><td><a href='DeleteStudent?rollno="+bean.getRollno()+"'>Delete</a></td></tr>");
		}
		out.println("</table>");
		
		out.println("</table>");
		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	
	}

}
