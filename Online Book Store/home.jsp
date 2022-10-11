
<jsp:useBean id="user" scope="session"  class="obs.User" />
<jsp:useBean id="cart" scope="session"  class="obs.Cart" />


<%@ page import="java.util.*"%>

<style>
td {font:10pt verdana}
th {font:700 10pt verdana}
h2 {font:700 16pt arial}
a {font:700 10pt verdana;color:darkgreen}
</style>

<%
  String act = request.getParameter("act");

  if ( act != null )
  {
   if( act.equals("Finalize Order"))
   {
     String orderid;
    
      orderid =  cart.finalizeOrder( user.getUserid());
      if ( orderid == null)
      {
         out.println("Sorry! Order Cannot be finalized.");
         return;
      }
      else
      {
         out.println("Order Has Been Finalized. Order id : " + orderid );
         out.println("<a href=home.jsp>Continue...</a>");
         cart.clearAll();
         return;
      }

       
   }   

   if ( act.equals("remove"))
   {
    cart.removeItem( request.getParameter("isbn"));
   }
   else 
    if ( act.equals("Update Cart"))
    {
  
      String isbn[] = (String []) request.getParameterValues("isbn");
      String qty[] = (String []) request.getParameterValues("qty");

      for (int i = 0 ;i < isbn.length ;i ++)
         cart.updateQty(isbn[i], Integer.parseInt( qty[i]));

    }
    else
     if ( act.equals("Clear Cart"))
          cart.clearAll();
   } // end of outer if
 

%>



<html>
<body bgcolor="beige">


<table border=1 border=1  width=100%>
<tr style="font:700 11pt verdana;background-color:green;color:white">
<td>
Welcome <b><jsp:getProperty name="user" property="uname"/> </b> 
</tr>

<tr style="font:10pt verdana">
<td>
<h2>Shopping Cart </h2>


<table  width=100%>
<tr>
<td width=70%>

<form action="home.jsp" method="get">
<table border=1 style="background-color:lightgreen" width="100%">  
<tr>
<th>Book Title
<th>Price
<th>Quantity
<th>Amount
<th>&nbsp;
</tr>

<%
 obs.Item item;
 
 ArrayList items = cart.getItems();
 Iterator  itr = items.iterator();
 int total = 0;

 while (  itr.hasNext())
 {
    item = (obs.Item) itr.next();
    total += item.getQty() * item.getPrice();
%>

<tr>
<td>
<input type=hidden value=<%=item.getIsbn()%> name=isbn>
<%= item.getTitle()%>
<td align="right"><%= item.getPrice()%>
<td align="center"><input type=text name=qty  size=5 value=<%=item.getQty()%>>
<td align="right"><%=item.getQty() * item.getPrice()%>
<td align="center"><a href=home.jsp?act=remove&isbn=<%=item.getIsbn()%>>Remove</a>
</tr>

<%
 }
%>
<tr>
<td colspan=5 style="text-align:center;font:700 12pt verdana;color:navy">
Total Amount : <%=total%>
</tr>


</table>

</td>
<td>

<input type=submit value="Update Cart"  name="act">
<p>
<input type=submit value="Clear Cart"  name="act">
<p>
<input type=submit value="Finalize Order"  name="act">

</tr>
</table>

</form>
  
</td>
</tr>

<tr>
<td>
[<a href="changeprofile.jsp">Change User Details</a>] &nbsp;&nbsp;
[<a href="browsebooks.jsp">Browse Books</a>] &nbsp;&nbsp;
[<a href="querybooks.jsp">Query Books</a>] &nbsp;&nbsp;
[<a href="ordershistory.jsp">Orders History</a>] &nbsp;&nbsp;
[<a href=logout.jsp> Logout </a>]
</td>
</tr>

</table>

</body>
</html>
