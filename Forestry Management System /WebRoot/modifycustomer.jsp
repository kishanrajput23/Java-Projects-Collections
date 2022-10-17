<html>
<body>
<%System.out.println("....usebean entered...1."); %>

<jsp:useBean id="c2" class="beans.CustomerBean" scope="request">

<%System.out.println("....usebean entered...2."); %>

<jsp:setProperty  name="c2" property="*"/>

<%System.out.println("....usebean entered...3."); %>

<%
int i=c2.Update(); 
%>

<%
if(i==1)
response.setHeader("Refresh","4;URL=Success.html");
else
response.setHeader("Refresh","4;URL=Fail.html");
%>

CUSTOMER DATA UPDATED

<%
System.out.println("....usebean entered...4."); 
%>

</jsp:useBean>
</body>
</html>
