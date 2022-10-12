package com.javatpoint.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatpoint.beans.AccountantBean;
import com.javatpoint.beans.StudentBean;
import com.javatpoint.dao.AccountantDao;
import com.javatpoint.dao.StudentDao;
@WebServlet("/EditAccountant")
public class EditAccountant extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
	 	String email=request.getParameter("email");
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		String contact=request.getParameter("contact");
		
		AccountantBean bean=new AccountantBean(id,name, email, password, address, contact);
		AccountantDao.update(bean);
		response.sendRedirect("ViewAccountant");
		
		out.close();
	}

}
