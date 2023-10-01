<jsp:useBean  id="user" class="obs.User" scope="session" />

<%
   if  (  user.isLogged() )
       response.sendRedirect("home.jsp");
  else
      response.sendRedirect("login.html");
%>
