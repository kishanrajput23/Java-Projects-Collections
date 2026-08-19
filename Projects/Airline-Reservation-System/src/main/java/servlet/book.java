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
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gursangeet
 */
public class book extends HttpServlet {

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
        String date = request.getParameter("fdate");
        String time = request.getParameter("ftime");
        String cardno = request.getParameter("cardno");
        String CVV = request.getParameter("CVV");
        String expiry = request.getParameter("expiry");
        String id = request.getParameter("hiddenid");
        String uid = (String) session.getAttribute("userid");
        int userid = Integer.parseInt(uid);
        int flightid = Integer.parseInt(id);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql:///" + db + "", dbuser, dbpass);
            CallableStatement cstmt = null;
            Statement stmt = connection.createStatement();
            String SQL = "{call sp_bookflights"
                    + "(" + flightid + "," + userid + ",'" + date + "',"
                    + "'" + time + "')}";

            cstmt = connection.prepareCall(SQL);
            ResultSet rs = cstmt.executeQuery(SQL);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columns = rsmd.getColumnCount();
            while (rs.next()) {
                for (int x = 1; x <= columns; x++) {
                    if ("bid".equals(rsmd.getColumnName(x))) {
                        session.setAttribute("bid", rs.getString("bid"));
                        int bid = rs.getInt("bid");
                        ResultSet rs2 = stmt.executeQuery("select f.flightnumber,f.source,f.destination,b.flightdate,b.flighttime,u.email from "
                                + "flightmaster f join bookingmaster b on f.flightid = b.flightid join usermaster u on u.userid = b.userid where b.id = " + bid + "");
                        while (rs2.next()) {
                            String sub = "Your flight details.";
                            String msg = "Thanks for book Flight."
                                    + "<br>" + "Your flight details " + "<br>" + ""
                                    + "Flight number : " + rs2.getString("flightnumber") + "" + "<br>" + "Source :" + rs2.getString("source") + "" + "<br>"
                                    + "Destination : " + rs2.getString("destination") + "" + "<br>" + "Flight date : " + rs2.getString("flightdate") + "" + "<br>" + "Flight time : " + rs2.getString("flighttime") + "";
                            emailsender.send(rs2.getString("email"), sub, msg);
                        }

                    }
                }
            }
            response.sendRedirect("summary.jsp");
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
