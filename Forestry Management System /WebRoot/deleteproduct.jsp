<%@ page errorPage="ExceptionHandler.jsp" %>
<html>
<body>
<%System.out.println("....usebean entered...1."); %>

<jsp:useBean id="c5" class="beans.ProductBean" scope="request">

<%System.out.println("....usebean entered...2."); %>

<jsp:setProperty  name="c5" property="prodid" value='<%=Integer.parseInt(request.getParameter("prodid").trim())%>'/>

<%System.out.println("....usebean entered...3."); %>

<%
int i=c5.delete(Integer.parseInt(request.getParameter("prodid").trim())); 
%>

<%
if(i==1)
response.setHeader("Refresh","4;URL=Success.html");
else
response.setHeader("Refresh","4;URL=Fail.html");
%>
PRODUCT DATA DELETED

<%
System.out.println("....usebean entered...4."); 
%>

</jsp:useBean>
</body>
</html>
