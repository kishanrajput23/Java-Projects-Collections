<jsp:useBean id="user"  scope="session"  class="obs.User"/>

<jsp:setProperty name="user" property="*" />

<%
   if (!user.isLogged())
      response.sendRedirect("login.html");

%>

<html>
<style>
h2{color:bottlegreen;font:700 16pt arial}
h3{color:navy;font:700 12pt arial}
td {font:10pt verdana}
a {font:10pt verdana;color:bottlegreen}
body {font:10pt verdana}

</style>

<body bgcolor="beige">

<h2>Change Profile </h2>
<form action="changeprofile.jsp" method="post">
<h3>Personal Details </h3>
<table>
<tr>
<td>
Email Address
<td>
<input type=text name=email size=30 value=<%=user.getEmail()%>>
</tr>

<tr>
<td>Mailing Address
<td>
<textarea name="address" rows=3 cols=30><%=user.getAddress()%></textarea>
</td>
</tr>

<tr>
<td>
Phone Number
<td>
<input type=text  name=phone  size=30 value='<%=user.getPhone()%>'>
</tr>
</table>

<h3>Password </h3>

<table>
<tr>
<td>
New Password
<td>
<input type=password name=pwd size=20>
</tr>
<tr>
<td>
Confirm Password
<td>
<input type=password name=pwd2 size=20>
</tr>

</table>

<p>


<input type=submit value="Update Profile">
<input type=reset value="Reset"> <a href="home.jsp">Home Page</a>
</form>


<%

  // do it if any invoked by itself
  if ( request.getParameter("email") == null)
    return;

  String res = user.updateProfile( request.getParameter("pwd") );
    
  if ( res == null)
      out.println("Profile Updated Successfully.");
  else
      out.println("Error : " + res);
 
  out.println("Click <a href=home.jsp>here</a> to continue...");  

%>


</body>
</html>   