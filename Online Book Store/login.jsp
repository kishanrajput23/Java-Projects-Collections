
<html>
<body bgcolor="beige">
<center>

<jsp:useBean id="user" class="obs.User" scope="session" />

<jsp:setProperty  name="user" property="*" />

<%
  user.login();
  if (! user.isLogged())
%>
<h3>Invalid Login. Click <a href=login.html>here</a> to try again! </h3>
<%
  else
     response.sendRedirect("home.jsp"); 
%>

</center>
</body>
</html>
     
    
   
