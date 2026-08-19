<%-- 
    Document   : viewflights
    Created on : Apr 26, 2017, 11:17:29 PM
    Author     : Gursangeet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
    <head>
        <title>View Flights</title>
        <meta name="description" content="website description" />
        <meta name="keywords" content="website keywords, website keywords" />
        <meta http-equiv="content-type" content="text/html; charset=windows-1252" />

        <link href="bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" type="text/css" href="css/style.css" /> 
        <!-- modernizr enables HTML5 elements and feature detects -->
        <script type="text/javascript" src="js/modernizr-1.5.min.js"></script>
        <style>
            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;
                padding: 14px;
                color:white;
                font-size:15px;
            }
        </style>
    </head>

    <body id="main">
        <div >
            <%
                String userid = (String) session.getAttribute("userid");

                if (userid != null && userid != "") {
                    String usertype = (String) session.getAttribute("usertype");
                    int utype = Integer.parseInt(usertype);
            %>
            <header>
                <div id="banner">
                    <div id="welcome">
                        <h2>Geet Airlines</h2>
                    </div><!--close welcome-->			  	
                </div><!--close banner-->	
            </header>

            <nav>
                <div id="menubar">
                    <ul id="nav">
                        <li><a href="home.jsp">Home</a></li>
                        <li class="current"><a href="viewflights.jsp">All flights</a></li>
                        <li><a href="contact.jsp">Contact Us</a></li>
                            <%if (utype == 1) {%>
                        <li><a href="addflights.jsp">Add flights</a></li>
                        <li><a href="viewbookings.jsp">View bookings</a></li>
                            <%}%>
                        <li><a href="logout">Logout</a></li>
                    </ul>
                </div><!--close menubar-->	
            </nav>	

            <div id="site_content">		

                <div class="slideshow">
                    <ul class="slideshow">
                        <li class="show"><img width="940" height="300" src="images/home_1.jpg" alt="&quot;Airlines&quot;" /></li>
                        <li><img width="940" height="300" src="images/home_2.jpg" alt="&quot;Airlines&quot;" /></li>
                    </ul> 
                </div><!--close slideshow-->	

                <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
                                   url="jdbc:mysql://localhost/airline"
                                   user="root"  password="root"/>

                <sql:query dataSource="${snapshot}" var="result">
                    SELECT * from flightmaster;
                </sql:query>
                <div id="content">
                    <div class="content_item">
                        <h1>Flight Booking</h1> 
                        <table>
                            <tr>
                                <th>S.No</th>
                                <th>Flight No.</th>
                                <th>Provider</th>
                                <th>Source</th>
                                <th>Destination</th>
                                <th>Price</th>
                                    <%if (utype == 1) {%>
                                <th>Created date</th>
                                    <%}%>
                                <th>Duration</th>
                                    <%if (utype == 1) {%>
                                <th>Edit</th>
                                <th>Delete</th>
                                    <%} else {%>
                                <th>Book</th>
                                    <%}%>
                            </tr>

                            <c:forEach var="row" items="${result.rows}" varStatus="status">
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${row.flightnumber}</td>
                                    <td>${row.provider}</td>
                                    <td>${row.source}</td>
                                    <td>${row.destination}</td>
                                    <td>${row.price}</td>
                                    <%if (utype == 1) {%>
                                    <td>${row.createddate}</td>
                                    <%}%>
                                    <td>${row.duration}</td>
                                    <%if (utype == 1) {%>
                                    <td><a href="editflight.jsp?id=${row.flightid}" class="btn btn-link">Edit</a></td>
                                    <td><a href="deleteflight?id=${row.flightid}" class="btn btn-link">Delete</a></td>
                                    <%} else {%>
                                    <td><a href="book.jsp?id=${row.flightid}" class="btn btn-link">Book</a></td>
                                    <%}%>
                                </tr>
                            </c:forEach>
                        </table>
                    </div><!--close content_item-->

                </div><!--close content-->   

            </div><!--close site_content-->  
        </div>
        <footer>
            <a href="index.jsp">Home</a> | <a href="viewflights.jsp">All Flights</a> | <a href="contact.jsp">Contact</a><br/><br/>
        </footer> 



        <!-- javascript at the bottom for fast page loading -->
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/image_slide.js"></script>

        <%
            } else {
                out.print("<div style='padding: 200px 0px 0px 520px;'><h1><span style='color:white;font-size:45px;'>session expired</span></h1><br><div  style='padding: 0px 0px 0px 90px;'><div class='button_small'><a style='padding-left:20px;' href='login.jsp' >Login</a></div></div></div>");
            }
        %>
        <!--close main-->
    </body>
</html>
