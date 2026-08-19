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
public class LoginServlet extends HttpServlet 
{
    
  public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
  {
   
      String email = request.getParameter("email");
      String password = request.getParameter("password");
      
      
      
      
      UserDAO dao = new UserDAO(DbConnect.getConnection());
      
      
      User u = dao.loginUser(email,password);
      
      HttpSession session = request.getSession();
      
      if(u!=null)
      {
            session.setAttribute("user",u);
            response.sendRedirect("index.jsp");
      }
      else
      {
            session.setAttribute("invalidMsg","Invalid email or password");
            response.sendRedirect("login.jsp");
            
      }
      
      
      
  }
    
}
