<%-- 
    Document   : home.jsp
    Created on : Apr 27, 2017, 12:23:43 PM
    Author     : Gursangeet
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="Objects.getflights"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Geet Airlines</title>
        <meta name="description" content="website description" />
        <meta name="keywords" content="website keywords, website keywords" />
        <meta http-equiv="content-type" content="text/html; charset=windows-1252" />
        <link href="bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/AdminLTE.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <link href="chosen/chosen.css" rel="stylesheet" type="text/css"/>
        <!-- modernizr enables HTML5 elements and feature detects -->
        <script type="text/javascript" src="js/modernizr-1.5.min.js"></script>
        <style>
            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;
                padding: 25px;
                color:white;
                font-size:15px;
            }
        </style>
    </head>

    <body id="main">
        <div >
            <%
                String ss = (String) session.getAttribute("userid");
                if (ss != null && ss != "") {
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
                        <li class="current"><a href="home.jsp">Home</a></li>
                        <li><a href="viewflights.jsp">All flights</a></li>
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
                        <li class="show"><img width="940" height="300" src="images/home_1.jpg" alt="&quot;Geet Airlines&quot;" /></li>
                        <li><img width="940" height="300" src="images/home_2.jpg" alt="&quot;Geet Airlines&quot;" /></li>
                        <li><img width="940" height="300" src="images/image-3.jpg" alt="&quot;Geet Airlines&quot;" /></li>
                    </ul> 
                </div><!--close slideshow-->	


                <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
                                   url="jdbc:mysql://localhost/airline"
                                   user="root"  password="root"/>

                <sql:query dataSource="${snapshot}" var="result">
                    SELECT  provider from provider;
                </sql:query>
                <sql:query dataSource="${snapshot}" var="result2">
                    SELECT  location from locations;
                </sql:query>

                <div id="content">
                    <div class="content_item" style="width:900px;">
                        <h1>Search Flights</h1> 

                        <div class="form-group">
                            <div class="col-lg-12" style="    padding-bottom: 32px;">
                                <div class="form-inline">
                                    <form class="" action="search" method="POST">
                                        <div class="form-group ">
                                            <div class="col-lg-3">
                                                <select class="form-control" placeholder="Provider" name="fprovider" >
                                                    <c:forEach var="row" items="${result.rows}" varStatus="status">  
                                                        <option value="${row.provider}" >${row.provider}</option>
                                                    </c:forEach>
                                                </select>

                                            </div>
                                        </div> 
                                        <div class="form-group ">
                                            <div class="col-lg-3">
                                                <select class="form-control" placeholder="Source" name="fsource">
                                                    <c:forEach var="row" items="${result2.rows}" varStatus="status">  
                                                        <option value="${row.location}" >${row.location}</option>
                                                    </c:forEach>
                                                </select>    
                                            </div>
                                        </div> 
                                        <div class="form-group ">
                                            <div class="col-lg-3">
                                                <select class="form-control" placeholder="Destination" name="fdestination">
                                                    <c:forEach var="row" items="${result2.rows}" varStatus="status">  
                                                        <option value="${row.location}" >${row.location}</option>
                                                    </c:forEach>
                                                </select>  
                                            </div>
                                        </div>
                                        <button class="btn btn-primary" type="submit" >Search</button>
                                </div> 

                                </form>
                            </div>
                        </div>
                    </div>



                    <table>
                        <tr>
                            <th>S.No</th>
                            <th>Flight No.</th>
                            <th>Provider</th>
                            <th>Source</th>
                            <th>Destination</th>
                            <th>Price</th>
                            <th>Duration</th>
                            <th>Book</th>
                        </tr>

                        <c:forEach var="row" items="${flightlist}" varStatus="status">
                            <tr>
                                <td>${status.count}</td>
                                <td>${row.getflightnumber()}</td>
                                <td>${row.provider}</td>
                                <td>${row.source}</td>
                                <td>${row.destination}</td>
                                <td>${row.price}</td>
                                <td>${row.duration}</td>
                                <td><a href="book.jsp?id=${row.flightid}" class="btn btn-link">Book</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div><!--close content_item-->

            </div><!--close site_content-->  	
        </div>
        <footer>
            <a href="index.jsp">Home</a> | <a href="viewflights.jsp">All Flights</a> | <a href="contact.jsp">Contact</a><br/><br/>
        </footer> 



        <!-- javascript at the bottom for fast page loading -->
        <script src="js/jquery-2.1.1.js" type="text/javascript"></script>
        <script src="bootstrap-3.3.7-dist/js/bootstrap.js" type="text/javascript"></script>
        <script type="text/javascript" src="js/image_slide.js"></script>
        <script src="js/chosen.jquery.js" type="text/javascript"></script>
        <%
            } else {
                out.print("<div style='padding: 200px 0px 0px 520px;'><h1><span style='color:white;font-size:45px;'>session expired</span></h1><br><div  style='padding: 0px 0px 0px 90px;'><div class='button_small'><a style='padding-left:20px;' href='login.jsp' >Login</a></div></div></div>");
            }
        %>
    </div><!--close main-->
</body>
</html>