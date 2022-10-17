<html>
<body>
<%System.out.println("....usebean entered...1."); %>

<jsp:useBean id="c4" class="beans.OrdersBean" scope="request">

<%System.out.println("....usebean entered...2."); %>

<jsp:setProperty  name="c4" property="*"/>

<%System.out.println("....usebean entered...3."); %>

<%
int i=c4.insert(); 
%>

<%
if(i==1)
{
out.println("Orders DATA INSERTED");
response.setHeader("Refresh","4;URL=Success.html");
}
else
{
out.println("the order id has already placed");
response.setHeader("Refresh","4;URL=Fail.html");
}
%>



<%
System.out.println("....usebean entered...4."); 
%>

</jsp:useBean>
</body>
</html>
