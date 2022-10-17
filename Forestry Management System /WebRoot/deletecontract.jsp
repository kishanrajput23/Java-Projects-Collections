<%@ page errorPage="ExceptionHandler.jsp" %>
<html>
<body>
<%System.out.println("....usebean entered...1."); %>

<jsp:useBean id="c1" class="beans.ContractBean" scope="request">

<%System.out.println("....usebean entered...2."); %>

<jsp:setProperty  name="c1" property="contractno" value='<%=Integer.parseInt(request.getParameter("contractno").trim())%>'/>

<%System.out.println("....usebean entered...3."); %>

<%
int i=c1.delete(Integer.parseInt(request.getParameter("contractno").trim())); 
%>

<%
if(i==1)
response.setHeader("Refresh","4;URL=Success.html");
else
response.setHeader("Refresh","4;URL=Fail.html");
%>

CONTRACT DATA DELETED

<%
System.out.println("....usebean entered...4."); 
%>

</jsp:useBean>
</body>
</html>
