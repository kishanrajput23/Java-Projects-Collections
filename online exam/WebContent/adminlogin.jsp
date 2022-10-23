<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="F:\wallies\HD Wallpapers\img36.jpg">
<form name="f1" method="post">
<CENTER>
<BR><BR><BR><BR><BR>
<table cellpadding=8 cellspacing=8 border="10" bgcolor="transparent">
<th bgcolor="transparent" colspan=2>
<font face="Times New Roman" color=LIGHTgrey size=5 >ADMINISTRATOR LOGIN</FONT><BR></th>

<tr bgcolor="transparent">
<td valign=top> 
<font size=5 face="Times New Roman" color=LIGHTYELLOW>
<b>                 USER_ID              </b>
</font>
<input type="text" name="t1" value="" size=20 maxlength=20></td>
</tr>

<tr bgcolor="transparent">
<td valign=top> 
<font size=5 face="Times New Roman" color=LIGHTYELLOW>
<b>PASSWORD</b>
</font>
<input type="password" name="t2" value="" size=20 maxlength=20></td>
</tr>

<tr bgcolor="transparent">
<td valign=top> 
<input type="button" name="b1" value="    LOGIN     " onclick="location.href='adminupdate.jsp'">
<input type="button" value="        EXIT      " onclick="location.href='page1.jsp'">
</tr>


</TABLE>
</CENTER>

<%
String user=request.getParameter("t1");
String pass=request.getParameter("t2");


         if(user=="anil" && pass=="yadav")
             {
 %>
             <jsp:forward page="adminupdate.jsp" />
  <%       	 }
         
  
    
%>
</form>
</body>
</html>