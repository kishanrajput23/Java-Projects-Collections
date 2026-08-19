/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.servlet;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javax.servlet.http.*;


/**
 *
 * @author VINIT
 */
public class LogoutServlet extends HttpServlet
{
     
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException 
    {
       HttpSession session = request.getSession();
       
       session.getAttribute("user");
       
       session.removeAttribute("user");
       
       
       HttpSession session2 = request.getSession();
       
       session2.setAttribute("LogOutMsg","Logout Successfully....");
       
       
       response.sendRedirect("login.jsp");
       
    }

}