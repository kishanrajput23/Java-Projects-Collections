<%@ page errorPage="ExceptionHandler.jsp" %>

<html>
<body>
<%System.out.println("....usebean entered...1."); %>

<jsp:useBean id="c3" class="beans.HaulierBean" scope="session">

<%System.out.println("....usebean entered...2."); %>

<jsp:setProperty  name="c3" property="haulid" value='<%=Integer.parseInt(request.getParameter("haulid").trim())%>'/>

<%System.out.println("....usebean entered...3."); %>

<%
int i=c3.delete(Integer.parseInt(request.getParameter("haulid").trim())); 
%>

<%
if(i==1)
response.setHeader("Refresh","4;URL=Success.html");
else
response.setHeader("Refresh","4;URL=Fail.html");
%>

HAULIER DATA DELETED

<%
System.out.println("....usebean entered...4."); 
%>

</jsp:useBean>
</body>
</html>
