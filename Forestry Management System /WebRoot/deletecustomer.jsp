<%@ page errorPage="ExceptionHandler.jsp" %>
<html>
<body>
<%System.out.println("....usebean entered...1."); %>

<jsp:useBean id="c2" class="beans.CustomerBean" scope="request">

<%System.out.println("....usebean entered...2."); %>

<jsp:setProperty  name="c2" property="custid" value='<%=Integer.parseInt(request.getParameter("custid").trim())%>'/>

<%System.out.println("....usebean entered...3."); %>

<%
int i=c2.delete(Integer.parseInt(request.getParameter("custid").trim())); 
%>

<%
if(i==1)
response.setHeader("Refresh","4;URL=Success.html");
else
response.setHeader("Refresh","4;URL=Fail.html");
%>

CUSTOMER DATA DELETED

<%
System.out.println("....usebean entered...4."); 
%>

</jsp:useBean>
</body>
</html>
