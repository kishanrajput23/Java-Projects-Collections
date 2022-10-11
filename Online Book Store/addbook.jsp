<jsp:useBean  id="cart"  class="obs.Cart"  scope="session" />
<jsp:useBean  id="user"  class="obs.User"  scope="session" />

<%
  // check whether user has logged in, otherwise send user to login page
  out.println( user.isLogged());

  if (!user.isLogged())
   response.sendRedirect("login.html");

  // read data about item

  String  isbn = request.getParameter("isbn");

  cart.addItem(isbn);

  response.sendRedirect("home.jsp");

%>

  