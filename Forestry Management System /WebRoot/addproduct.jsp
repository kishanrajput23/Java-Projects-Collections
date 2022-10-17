<html>
<body>
<%System.out.println("....usebean entered...1."); %>

<jsp:useBean id="c5" class="beans.ProductBean" scope="request">

<%System.out.println("....usebean entered...2."); %>

<jsp:setProperty  name="c5" property="*"/>

<%System.out.println("....usebean entered...3."); %>

<%
int i=c5.insert(); 
%>

<%
if(i==1)
{
out.println("PRODUCTS DATA INSERTED");
response.setHeader("Refresh","4;URL=Success.html");
}
else
{
out.println("PRODUCTS DATA NOT INSERTED");
response.setHeader("Refresh","4;URL=Fail.html");
}
%>



<%
System.out.println("....usebean entered...4."); 
%>

</jsp:useBean>
</body>
</html>
