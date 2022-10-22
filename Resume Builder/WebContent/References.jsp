<%@page import="org.pk.resume.builder.beans.References"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.pk.resume.builder.dao.UserService"%>
<%@page import="org.pk.resume.builder.session.ReferencesSessionConstant"%>
<%@page import="org.pk.resume.builder.constants.GlobalConstants"%>
<%@page import="org.pk.resume.builder.session.ProjectSessionConstant"%>
<%@page import="org.pk.resume.builder.beans.Projects"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		UserService us = new UserService();
		ArrayList<References> refers =  GlobalConstants.references;
	%>
	<jsp:include page="Menu.jsp"/>
		<fieldset>
			<legend>Achievements</legend>
			<table style="text-align: center; width: 100%;" align="center" border="1" cellspacing="0">
				<tr>
					<th>Sr No</th>
					<th>Name</th>
					<th>Designation</th>
					<th>Affiliation</th>
					<th>Contact NO</th>
					<th>Email-ID</th>
				</tr>

				<%
					if(refers != null && !refers.isEmpty())
					{ 
						for(int i=0; i<refers.size();i++)
						{
							References refs = refers.get(i);
				%>
				<tr>
					<td><%=i+1%></td>
					<td><%=refs.getName()%></td>
					<td><%=refs.getDesignation()%></td>
					<td><%=refs.getAffiliation()%></td>
					<td><%=refs.getContactNo()%></td>
					<td><%=refs.getEmailId()%></td>
				</tr>
				<%
					}}
				%>
			</table>
		<br>
	
	<form method="post" action="AddReferences.jsp">
		<table>
			<tr>
				<td>Name of Reference</td>
				<td><input type="text"
					name="<%=ReferencesSessionConstant.NAME%>"></td>
			</tr>
			<tr>
				<td>Designation</td>
				<td><input type="text"
					name="<%=ReferencesSessionConstant.DESIGNATION%>"></td>
			</tr>

			<tr>
				<td>Affiliation</td>
				<td><input type="text"
					name="<%=ReferencesSessionConstant.AFFILIATION%>"></td>
			</tr>

			<tr>
				<td>Email</td>
				<td><input type="text"
					name="<%=ReferencesSessionConstant.EMAILID%>"></td>
			</tr>
			<tr>
				<td>Contact No.</td>
				<td><input type="text"
					name="<%=ReferencesSessionConstant.CONTACTNO%>"></td>
			</tr>
			<tr>
				<td></td> 
				<td colspan="2"><input type="submit" value="Add" name="next"/></td>
				<td colspan="2"><input type="submit" value="Next" name="next" /></td>
				<td></td><td></td><td></td>
				<td><input type="reset" value="Reset" /></td>
			</tr>

		</table>
	</form>
	</fieldset>
</body>
</html>