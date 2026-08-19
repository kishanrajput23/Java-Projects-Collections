<%-- 
    Document   : contact
    Created on : Apr 21, 2017, 1:59:59 PM
    Author     : Gursangeet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <title>Contact Us</title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=windows-1252" />
  <link href="bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet" type="text/css"/>
  <link rel="stylesheet" type="text/css" href="css/style.css" />
  <!-- modernizr enables HTML5 elements and feature detects -->
  <script type="text/javascript" src="js/modernizr-1.5.min.js"></script>
</head>

<body>
  <div id="main">
                  <%
                String userid = (String) session.getAttribute("userid");
                String usertype = (String) session.getAttribute("usertype");
                int utype = Integer.parseInt(usertype);
                if (userid != null && userid != "") {
                  // if (utype == 1) {
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
          <li><a href="viewflights.jsp">All Flights</a></li>
          <li class="current"><a href="contact.jsp">Contact Us</a></li>
                        <%if(utype == 1) {%>
                        <li ><a href="addflights.jsp">Add flights</a></li>
                        <li><a href="viewbookings.jsp">View bookings</a></li>
                            <%}%>
              
          <li><a href="logout">Logout</a></li>
        </ul>
      </div><!--close menubar-->	
	</nav>
    
	<div id="site_content">	
		

	  <div class="sidebar_container">       
       </div><!--close sidebar_container-->	
	
	  <div id="content">
        <div class="content_item">
             <h5><span style="font-size: 23px;color: mediumvioletred;">${success}</span></h5><%session.removeAttribute("success");%>    
		  <div class="form_settings">
                     <h1>Contact Us   </h1> 
            <p style="font-size:14px;padding-bottom: 15px;">Leave a message. We will be happy to help you.</p>           
            
            <form method="post" action="contactus">	
                
            <p><span>Name</span><input class="contact" type="text" name="name" value="" /></p>
            <p><span>Email Address</span><input class="contact" type="text" name="email" value="" /></p>
			<p><span>Message</span><textarea class="contact textarea" rows="8" cols="50" name="message"></textarea></p>
            
			
            <p style="padding-top: 15px"><span>&nbsp;</span><input class="submit" type="submit" name="contact_submitted" value="Send" /></p>
          </form></div><!--close form_settings-->
		</div><!--close content_item-->
      </div><!--close content-->   
	</div><!--close site_content-->  	
  
    <footer>
	  <a href="index.jsp">Home</a> | <a href="viewflights.jsp">All Flights</a> | <a href="contact.jsp">Contact</a><br/><br/>
    </footer>   
  
  <!--close main-->

  <!-- javascript at the bottom for fast page loading -->
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript" src="js/image_slide.js"></script>
      <%
                    //} else {
                      //  out.print("<div style='padding: 200px 0px 0px 520px;'><h1><span style='color:white;font-size:45px;'>Login as admin  </span></h1><br><div  style='padding: 0px 0px 0px 90px;'><div class='button_small'><a style='padding-left:20px;' href='login.jsp' >Login</a></div></div></div>");
                   // }
                } 
                else {
                    out.print("<div style='padding: 200px 0px 0px 520px;'><h1><span style='color:white;font-size:45px;'>Session expired  </span></h1><br><div  style='padding: 0px 0px 0px 90px;'><div class='button_small'><a style='padding-left:20px;' href='login.jsp' >Login</a></div></div></div>");
                }
            %>
  </div>
</body>
</html>
