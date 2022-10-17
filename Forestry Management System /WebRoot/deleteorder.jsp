<%@ page errorPage="ExceptionHandler.jsp" %>
<html>
<body>
<%System.out.println("....usebean entered...1."); %>

<jsp:useBean id="c4" class="beans.OrdersBean" scope="session">

<%System.out.println("....usebean entered...2."); %>

<jsp:setProperty  name="c4" property="orderno" value='<%=Integer.parseInt(request.getParameter("orderno").trim())%>'/>

<%System.out.println("....usebean entered...3."); %>

<%
int i=c4.delete(Integer.parseInt(request.getParameter("orderno").trim())); 
%>

<%
if(i==1)
response.setHeader("Refresh","4;URL=Success.html");
else
response.setHeader("Refresh","4;URL=Fail.html");
%>
ORDER DATA DELETED

<%
System.out.println("....usebean entered...4."); 
%>

</jsp:useBean>
</body>
</html>
