<html>

<style>
h2{color:navy;font:700 20pt arial}
h4 {color:brwon;font:700 11pt verdana}
td {font:700 10pt verdana}
a {font:700 10pt verdana;color:darkgreen}

</style>

<body bgcolor="beige">

<h2>Query Books</h2>
<form action="querybooks.jsp" method="post" >
<table>
<tr>
<td>
Category 
<td> 
<select name="cat">
<option value="all">All Categories
<option value="ora">Oracle
<option value=".net">.NET 
<option value="java">Java 
</select>
Title Contains 
<input type=text name=title size=20>
</tr>

<tr>
<td>
Author Name Contains
<td>
<input type=text size=20 name=author>
Price From
<input type=text name=fromprice size=10>
To
<td>
<input type=text name=toprice size=10>
</tr>
</table>
<p>
<input type=submit value="Query">
<a href="gohome.jsp">Home Page </a>

</form>

<%
 String cat = request.getParameter("cat");
 if ( cat == null)
  return;

 String cond = "1=1";

 if (!cat.equals("all") )
     cond = cond + " and cat = '" + cat + "'";

 String title = request.getParameter("title");

 if ( !title.equals(""))
    cond = cond + " and title like '%" + title + "%'";


 String author = request.getParameter("author");

 if ( !author.equals(""))
    cond = cond + " and author like '%" + author + "%'";


 String fromprice = request.getParameter("fromprice");

 if ( !fromprice.equals(""))
    cond = cond + " and price >= " + fromprice;

 String toprice = request.getParameter("toprice");

 if ( !toprice.equals(""))
    cond = cond + " and price <= " + toprice;

 request.setAttribute("cond", cond);

%>
 
<jsp:include  page="listbooks.jsp" flush="true"/>

</body>
</html>   