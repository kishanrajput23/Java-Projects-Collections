/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.servlet;

import com.connection.DbConnect;
import com.dao.UserDAO;
import com.entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;



/**
 *
 * @author VINIT
 */

public class RegisterServlet extends HttpServlet 
{

  public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
  {
     
      String name = request.getParameter("name");
      String email = request.getParameter("email");
      String password = request.getParameter("password");
      
      
      User u = new User(name,email,password);
      
      UserDAO dao = new UserDAO(DbConnect.getConnection());
      
     boolean f = dao.userRegister(u);
          
     
     HttpSession session = request.getSession();
     
      if(f)
      {
          session.setAttribute("registersuccess","Registeration Successful");
          response.sendRedirect("register.jsp");
      }
      else
      {
          session.setAttribute("registerfail","Something Went Wrong...");
          response.sendRedirect("register.jsp");
      }
    
      
  }
    
}
