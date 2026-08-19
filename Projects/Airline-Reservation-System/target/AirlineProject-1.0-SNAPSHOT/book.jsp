<%-- 
    Document   : book
    Created on : Apr 27, 2017, 8:39:11 PM
    Author     : Gursangeet
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.CallableStatement"%>
<%@page import="java.sql.Connection"%>
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
        <link href="css/datepicker.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap-timepicker/css/bootstrap-timepicker.css" rel="stylesheet" type="text/css"/>
        <!-- modernizr enables HTML5 elements and feature detects -->
        <script type="text/javascript" src="js/modernizr-1.5.min.js"></script>
        <style >
            .newfont{
                font-size: 15px;
                color: white;
            }
        </style>
    </head>

    <body id="main">
        <div >
            <%
                String userid = (String) session.getAttribute("userid");
                String usertype = (String) session.getAttribute("usertype");
                if (userid != null && userid != "") {
                    String db = null;
                    String dbuser = null;
                    String dbpass = null;
                    db
                            = getServletContext().getInitParameter("mysql-db");
                    dbuser
                            = getServletContext().getInitParameter("mysql-user");
                    dbpass
                            = getServletContext().getInitParameter("mysql-pass");
                    String fid = request.getParameter("id");
                    int id = Integer.parseInt(fid);
                    String provider = null;
                    String source = null;
                    String destination = null;
                    String flightnumber = null;
                    String price = null;
                    String Duration = null;

                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection connection = DriverManager.getConnection("jdbc:mysql:///" + db + "", dbuser, dbpass);
                        CallableStatement cstmt = null;
                        String SQL = "select * from flightmaster where flightid = " + id + "";

                        cstmt = connection.prepareCall(SQL);
                        ResultSet rs = cstmt.executeQuery(SQL);
                        while (rs.next()) {
                            provider = rs.getString("provider");
                            source = rs.getString("source");
                            destination = rs.getString("destination");
                            flightnumber = rs.getString("flightnumber");
                            price = rs.getString("price");
                            Duration = rs.getString("duration");
                        }
                    } catch (Exception e) {
                        out.print("EXCEPTION IS:" + e);

                    }
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
                        <li ><a href="home.jsp">Home</a></li>
                        <li><a href="viewflights.jsp">All flights</a></li>
                        <li><a href="contact.jsp">Contact Us</a></li>
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
                


                <div id="content" style="width:915px;">
                    <div class="content_item" style="width:915px;">
                        <h4><span class="text-success pull-left">${success}<%session.removeAttribute("success");%></span></h4>
                        <h4><span class="text-danger pull-left">${error}<%session.removeAttribute("error");%></span></h4>
                     <div align="center"><span><h1>Book flight</h1></span></div> 
                        <form class="form-horizontal" id="bookingform" method="POST" action="book" >
                            <input type="hidden" name="flightno" value="<%=id%>">
                            <div class="form-group">
                                <label for="" class="col-sm-4 control-label newfont" >Flight number</label>
                                <div class="col-sm-6">
                                    <input readonly type="text" class="form-control input-sm" required id="inputName" value="<%=flightnumber%>">
                                </div>
                            </div>
                            <div class="form-group" >
                                <label for="" class="col-sm-4 control-label newfont" >Provider</label>
                                <div class="col-sm-6" >
                                    <input readonly type="text" class="form-control input-sm" required id="inputName" value="<%=provider%>">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="" class="col-sm-4 control-label newfont" >Source</label>
                                <div class="col-sm-6" >
                                    <input readonly type="text" class="form-control input-sm" required id="inputName" value="<%=source%>">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="" class="col-sm-4 control-label newfont" >Destination</label>
                                <div class="col-sm-6" >
                                   <input readonly type="text" class="form-control input-sm" required id="inputName" value="<%=destination%>">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="" class="col-sm-4 control-label newfont" >Total flight time</label>
                                <div class="col-sm-6" >
                                    <input  type="text" readonly class="form-control input-sm" value="<%=Duration%>" required placeholder="Total flight time">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="" class="col-sm-4 control-label newfont" >Price</label>
                                <div class="col-sm-6" >
                                    <input type="number" name="price" class="form-control input-sm" required value="<%=price%>" readonly  placeholder="Price">
                                </div>
                            </div>
                                <div class="form-group">
                                <label class="col-sm-4 control-label newfont">Flight date </label>
                                <div class="col-sm-6" >
                                    <input required readonly type="text" class="form-control input-sm" name="fdate" id="fdate">                                     
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label newfont">Flight Time </label>
                                <div class="col-sm-6" >
                                    <input required readonly type="text" class="form-control input-sm" name="ftime" id="ftime">                                     
                                </div>
                            </div>
                                 <div class="form-group">
                                <label class="col-sm-4 control-label newfont">Enter Card no.</label>
                                <div class="col-sm-6" >
                                    <input required type="number" name="cardno" class="form-control input-sm" maxlength="16" minlength="14" id="cardno">                                     
                                </div>
                            </div>
                                 <div class="form-group">
                                <label class="col-sm-4 control-label newfont">Enter CVV</label>
                                <div class="col-sm-6" >
                                    <input type="number" required name="CVV" class="form-control input-sm" maxlength="3" minlength="3" id="CVV">                                     
                                </div>
                            </div>
                                <div class="form-group">
                                <label class="col-sm-4 control-label newfont">Expiry date</label>
                                <div class="col-sm-6" >
                                    <input name="expiry" readonly required class="form-control input-sm" id="expiry">                                     
                                </div>
                            </div>
                            <input type="hidden"  id="hiddentime" value="<%=id%>" name="hiddenid">
                            <div align="center">
                                <input class="btn btn-primary" type="submit" onclick="submittime()" value="Book">
                            </div>

                        </form>
                    </div><!--close content_item-->
                </div><!--close content-->   

            </div><!--close site_content-->  	

            <footer>
                <a href="home.jsp">Home</a> | <a href="viewflights.jsp">All Flights</a> | <a href="contact.jsp">Contact</a><br/><br/>
            </footer> 



            <!-- javascript at the bottom for fast page loading -->
            <script src="js/jquery-2.1.1.js" type="text/javascript"></script>
            <script src="bootstrap-3.3.7-dist/js/bootstrap.js" type="text/javascript"></script>
            <script type="text/javascript" src="js/image_slide.js"></script>
            <script src="js/jquery.validate.js" type="text/javascript"></script>
            <script src="js/bootstrap-datepicker.js" type="text/javascript"></script>
            <script src="bootstrap-timepicker/js/bootstrap-timepicker.min.js" type="text/javascript"></script>
            <script>
                 $(function ( ) {

                $("#bookingform").validate();
                
            });
                $('#fdate').datepicker();
                $('#expiry').datepicker();
                $('#ftime').timepicker();
            </script>
            <%
                } else {
                    out.print("<div style='padding: 200px 0px 0px 520px;'><h1><span style='color:white;font-size:45px;'>Login as admin  </span></h1><br><div  style='padding: 0px 0px 0px 90px;'><div class='button_small'><a style='padding-left:20px;' href='login.jsp' >Login</a></div></div></div>");
                }
            %>
        </div><!--close main-->
    </body>
</html>

