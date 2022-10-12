<jsp:useBean  id="cart"  class="obs.Cart"  scope="session" />
<jsp:useBean  id="user"  class="obs.User"  scope="session" />

<%
  // check whether user has logged in, otherwise send user to login page
  
  if (!user.isLogged())
   response.sendRedirect("login.html");

  // read data about item

  String  ordid = request.getParameter("ordid");

  boolean  result = cart.cancelOrder( Integer.parseInt(ordid));
  if ( result ) 
      out.println("<h2>Order Has Been Cancelled.</h2>");
  else
      out.println("<h2>Order could not be cancelled.</h2>");
 


%>

<p>
<a href="ordershistory.jsp">Orders History </a>
&nbsp;&nbsp;
<a href="home.jsp">Home Page </a>


  