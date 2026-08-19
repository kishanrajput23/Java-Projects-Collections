/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Objects.getflights;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 *
 */
public class search extends HttpServlet {

    String db = null;
    String dbuser = null;
    String dbpass = null;

    public void init() {
        // Get the file location where it would be stored.
        db
                = getServletContext().getInitParameter("mysql-db");
        dbuser
                = getServletContext().getInitParameter("mysql-user");
        dbpass
                = getServletContext().getInitParameter("mysql-pass");
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String p = request.getParameter("fprovider");
         String s = request.getParameter("fsource");
          String d = request.getParameter("fdestination");
        HttpSession session = request.getSession();
        Statement stmt = null;
        List<getflights> flightlist = new ArrayList<getflights>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql:///" + db + "", dbuser, dbpass);
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from flightmaster "
                    + "where provider like '%"+ p +"%' and source like '%"+ s +"%' and destination like '%"+ d  +"%'");
            while (rs.next()) {
                String flightnumber = rs.getString("flightnumber");
                String source = rs.getString("source");
                String destination = rs.getString("destination");
                String duration = rs.getString("duration");
                float price = rs.getFloat("price");
                String provider = rs.getString("provider");
                int flightid = rs.getInt("flightid");
                getflights user = new getflights();
                user.setprice(price);
                user.setdestination(destination);
                user.setduration(duration);
                user.setsource(source);
                user.setflightnumber(flightnumber);
                user.setprovider(provider);
                user.setflightid(flightid);
                flightlist.add(user);
            }
            session.setAttribute("flightlist",flightlist);
            response.sendRedirect("home.jsp");
        } catch (Exception e) {
            out.print("EXCEPTION IS:" + e);

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
