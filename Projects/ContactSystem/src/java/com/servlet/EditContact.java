/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.servlet;

import com.connection.DbConnect;
import com.dao.ContactDao;
import com.entity.Contact;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 *
 * @author VINIT
 */
public class EditContact extends HttpServlet
{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        int cid = Integer.parseInt(request.getParameter("cid"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phno = request.getParameter("phno");
        String about = request.getParameter("about");
        
        Contact c = new Contact();
        
        c.setId(cid);
        c.setName(name);
        c.setEmail(email);
        c.setPhno(phno);
        c.setAbout(about);
        
        
        
        ContactDao dao = new ContactDao(DbConnect.getConnection());
        
        
        HttpSession session = request.getSession();
                boolean f = dao.UpdateContact(c);

        if(f)
        {
              session.setAttribute("successMsg","Contact Update successfully");
              response.sendRedirect("viewContact.jsp");
        }
        else
        {
              session.setAttribute("failedMsg","Something went wrong");
              response.sendRedirect("editContact.jsp?cid="+cid);
        }
        
        
    }
    

    

}
