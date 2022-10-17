<html>
<body>
<%System.out.println("....usebean entered...1."); %>

<jsp:useBean id="c2" class="beans.CustomerBean" scope="request">

<%System.out.println("....usebean entered...2."); %>

<jsp:setProperty  name="c2" property="*"/>

<%System.out.println("....usebean entered...3."); %>

<%
int i=c2.insert(); 
%>

<%
if(i==1)
{
response.setHeader("Refresh","4;URL=Success.html");
out.println("CUSTOMER DATA INSERTED");}
else
{
out.println("<FONT COLOR=RED>");

out.println("PLEASE ENTER THE CORRECT DATA");
out.println("</FONT>");
response.setHeader("Refresh","4;URL=Fail.html");}
%>



<%
System.out.println("....usebean entered...4."); 
%>

</jsp:useBean>
</body>
</html>
