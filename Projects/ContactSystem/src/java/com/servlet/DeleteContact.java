/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.servlet;

import com.connection.DbConnect;
import com.dao.ContactDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author VINIT
 */
public class DeleteContact extends HttpServlet 
{

    protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException
    {
          int cid = Integer.parseInt(request.getParameter("cid"));
          
          ContactDao dao = new ContactDao(DbConnect.getConnection());
          
         boolean f =  dao.DeleteContactById(cid);
   
         HttpSession session = request.getSession();
         
         
         if(f)
         {
             session.setAttribute("successMsg","Contact Deleted Successfully...");
             response.sendRedirect("viewContact.jsp");
         }
         else
         {
             
             session.setAttribute("failedMsg","Something went wrong");
             response.sendRedirect("viewContact.jsp");
         }
         
    }
    


}
