<html>
<body>
<%System.out.println("....usebean entered...1."); %>

<jsp:useBean id="c1" class="beans.ContractBean" scope="request">

<%System.out.println("....usebean entered...2."); %>

<jsp:setProperty  name="c1" property="*"/>

<%System.out.println("....usebean entered...3."); %>

<%
int i=c1.insert(); 
%>

<%
if(i==1)
{
out.println("CONTRACT DATA INSERTED");
response.setHeader("Refresh","4;URL=Success.html");
}
else
{

out.println("U ENTERED WRONG DATA PLEASE ENTER CORRECT DATA");

response.setHeader("Refresh","4;URL=Fail.html");
}
%>



<%
System.out.println("....usebean entered...4."); 
%>

</jsp:useBean>
</body>
</html>
