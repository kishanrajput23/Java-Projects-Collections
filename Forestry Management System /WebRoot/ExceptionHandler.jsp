<%@ page isErrorPage="true" import="java.io.*" %>
<html>
<head>
	<title>Exceptional Even Occurred!</title>
	<style>
	body, p { font-family:Tahoma; font-size:10pt; padding-left:30; }
	pre { font-size:8pt; }
	</style>
</head>
<body>

<%-- Exception Handler --%>
<font color="red">

</font>

<font color="red">
<%
out.println("PLEASE ENTER CORRECT DATA");
out.println("<!--");
StringWriter sw = new StringWriter();
PrintWriter pw = new PrintWriter(sw);
exception.printStackTrace(pw);
out.print(sw);
sw.close();
pw.close();
out.println("-->");
%>
</font>
</body>
</html>
