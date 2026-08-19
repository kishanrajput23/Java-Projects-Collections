/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.servlet;

import com.connection.DbConnect;
import com.dao.ContactDao;
import com.entity.Contact;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;


/**
 *
 * @author VINIT
 */
public class AddContact extends HttpServlet 
{

    
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
        int userId = Integer.parseInt(request.getParameter("userid"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phno = request.getParameter("phno");
        String about = request.getParameter("about");
        
        
        Contact c = new Contact(name,email,phno,about,userId);
        
        ContactDao dao = new ContactDao(DbConnect.getConnection());
        
        boolean f = dao.SaveContact(c);
        
        
        HttpSession session = request.getSession();
        
        if(f)
        {
              session.setAttribute("successMsg","Contact saved successfully");
              response.sendRedirect("addContact.jsp");

        }
        else
        {
              session.setAttribute("failedMsg","Something went wrong");
              response.sendRedirect("addContact.jsp");

        }
            
        
    }
    
}
