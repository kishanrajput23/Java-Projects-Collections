<html>
<body>
<%System.out.println("....usebean entered...1."); %>

<jsp:useBean id="c3" class="beans.HaulierBean" scope="request">

<%System.out.println("....usebean entered...2."); %>

<jsp:setProperty  name="c3" property="*"/>

<%System.out.println("....usebean entered...3."); %>

<%
int i=c3.Update(); 
%>

<%
if(i==1)
response.setHeader("Refresh","4;URL=Success.html");
else
response.setHeader("Refresh","4;URL=Fail.html");
%>

HAULIER DATA UPDATED

<%
System.out.println("....usebean entered...4."); 
%>

</jsp:useBean>
</body>
</html>
