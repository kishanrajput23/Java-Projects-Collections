/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * 
 */
public class edithandler extends HttpServlet {

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
        HttpSession session = request.getSession();
        String number = request.getParameter("fnumber");
        String provider = request.getParameter("fprovider");
        String source = request.getParameter("fsource");
        String dest = request.getParameter("fdest");
        String time = request.getParameter("ftime");
        String price = request.getParameter("price");
        String fno = request.getParameter("flightno");
        int flightno = Integer.parseInt(fno);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql:///" + db + "", dbuser, dbpass);
            CallableStatement cstmt = null;
            String SQL = "{call sp_editflights"
                    + "('" + number + "','" + provider + "','" + source + "',"
                    + "'" + dest + "','" + time + "','" + price + "'," + flightno + ")}";

            cstmt = connection.prepareCall(SQL);
            ResultSet rs = cstmt.executeQuery(SQL);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columns = rsmd.getColumnCount();
            while (rs.next()) {
                for (int x = 1; x <= columns; x++) {
                    if ("flightnumberexists".equals(rsmd.getColumnName(x))) {
                        session.setAttribute("error", "Flight number already exists.");
                        response.sendRedirect("addflights.jsp");
                    } else {
                        session.setAttribute("success", "Flight updated successfully.");
                        response.sendRedirect("addflights.jsp");
                    }
                }
            }
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
