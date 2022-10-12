<html>
<style>
h2{color:navy;font:700 20pt arial}
h4 {color:brwon;font:700 11pt verdana}
td {font:10pt verdana}
a {font:12pt verdana;color:navy}

</style>

<body bgcolor="beige">

<h2>Browse Available Books</h2>

<form action="browsebooks.jsp" method="post" >
Select Category : 
<select name="cat">
<option value="all">All Categories
<option value="ora">Oracle
<option value=".net">.NET 
<option value="java">Java 
</select>
<input type=submit value="Browse">

<a href="querybooks.jsp">Query Books </a> &nbsp;&nbsp;<a href="gohome.jsp">Home </a>

</form>

<%
 String cat = request.getParameter("cat");
 if ( cat == null)
    request.setAttribute("cond","1=1");
else
  if (!cat.equals("all") )
   request.setAttribute("cond", "cat='" + cat + "'");

%>
 
<jsp:include  page="listbooks.jsp" flush="true"/>


</body>
</html>   