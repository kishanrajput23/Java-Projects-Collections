<%-- 
    Document   : editflight
    Created on : Apr 27, 2017, 12:02:33 AM
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
                int utype = Integer.parseInt(usertype);
                if (userid != null && userid != "") {
                    if (utype == 1) {
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
                                          <%if (utype == 1) {%>
                        <li ><a href="addflights.jsp">Add flights</a></li>
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
                    SELECT location from locations;
                </sql:query>
                      <sql:query dataSource="${snapshot}" var="result2">
                    SELECT provider from provider;
                </sql:query>


                <div id="content" style="width:915px;">
                    <div class="content_item" style="width:915px;">
                        <h4><span class="text-success pull-left">${success}<%session.removeAttribute("success");%></span></h4>
                        <h4><span class="text-danger pull-left">${error}<%session.removeAttribute("error");%></span></h4>
                        <a href="viewflights.jsp" ><input class="btn btn-info pull-right" type="button" value="View"> </a><div align="center"><span><h1>Add flights</h1></span></div> 
                        <form class="form-horizontal" id="transferform" method="POST" action="edithandler" >
                            <input type="hidden" name="flightno" value="<%=id%>">
                            <div class="form-group">
                                <label for="" class="col-sm-4 control-label newfont" >Flight number</label>
                                <div class="col-sm-6">
                                    <input disabled type="text" name="fnumber" class="form-control input-sm" required id="inputName" value="<%=flightnumber%>" placeholder="Flight number">
                                </div>
                            </div>
                            <div class="form-group" >
                                <label for="" class="col-sm-4 control-label newfont" >Provider</label>
                                <div class="col-sm-6" >
                                   <select class="form-control" name="fprovider" >
                                        <c:forEach var="row" items="${result2.rows}" varStatus="status">  
                                            <option value="${row.provider}" >${row.provider}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="" class="col-sm-4 control-label newfont" >Source</label>
                                <div class="col-sm-6" >

                                    <select class="form-control" name="fsource" >
                                        <c:forEach var="row" items="${result.rows}" varStatus="status">  
                                            <option value="${row.location}" >${row.location}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="" class="col-sm-4 control-label newfont" >Destination</label>
                                <div class="col-sm-6" >
                                   <select class="form-control" name="fdest" >
                                        <c:forEach var="row" items="${result.rows}" varStatus="status">  
                                            <option value="${row.location}" >${row.location}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="" class="col-sm-4 control-label newfont" >Total flight time</label>
                                <div class="col-sm-6" >
                                    <input type="text" name="ftime" class="form-control input-sm" value="<%=Duration%>" required placeholder="Total flight time">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="" class="col-sm-4 control-label newfont" >Price</label>
                                <div class="col-sm-6" >
                                    <input type="number" name="price" class="form-control input-sm" required value="<%=price%>"  placeholder="Price">
                                </div>
                            </div>
                            <input type="hidden"  id="hiddentime" name="mtime">
                            <div align="center">
                                <input class="btn btn-primary" type="submit" onclick="submittime()" value="Save">
                            </div>

                        </form>
                    </div><!--close content_item-->
                </div><!--close content-->   

            </div><!--close site_content-->  	

            <footer>
                <a href="index.jsp">Home</a> | <a href="book.jsp">Book Movies</a> | <a href="contact.jsp">Contact</a><br/><br/>
            </footer> 



            <!-- javascript at the bottom for fast page loading -->
            <script src="js/jquery-2.1.1.js" type="text/javascript"></script>
            <script src="bootstrap-3.3.7-dist/js/bootstrap.js" type="text/javascript"></script>
            <script type="text/javascript" src="js/image_slide.js"></script>
            <script src="js/chosen.jquery.js" type="text/javascript"></script>

            <%
                 } else {
                    out.print("<div style='padding: 200px 0px 0px 520px;'><h1><span style='color:white;font-size:45px;'>Login as admin  </span></h1><br><div  style='padding: 0px 0px 0px 90px;'><div class='button_small'><a style='padding-left:20px;' href='login.jsp' >Login</a></div></div></div>");
                }
                } else {
                    out.print("<div style='padding: 200px 0px 0px 520px;'><h1><span style='color:white;font-size:45px;'>Login as admin  </span></h1><br><div  style='padding: 0px 0px 0px 90px;'><div class='button_small'><a style='padding-left:20px;' href='login.jsp' >Login</a></div></div></div>");
                }
            %>
        </div><!--close main-->
    </body>
</html>
