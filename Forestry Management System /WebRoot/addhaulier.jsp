<html>
<body>
<%System.out.println("....usebean entered...1."); %>

<jsp:useBean id="c3" class="beans.HaulierBean" scope="request">

<%System.out.println("....usebean entered...2."); %>

<jsp:setProperty  name="c3" property="*"/>

<%System.out.println("....usebean entered...3."); %>

<%
int i=c3.insert(); 
%>

<%
if(i==1)
{
out.println("HAULIER DATA INSERTED");
response.setHeader("Refresh","4;URL=Success.html");
}
else
{
out.println("HAULIER DATA NOT INSERTED");
response.setHeader("Refresh","4;URL=Fail.html");
}
%>



<%
System.out.println("....usebean entered...4."); 
%>

</jsp:useBean>
</body>
</html>
