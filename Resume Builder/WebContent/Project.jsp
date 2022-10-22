<%@page import="org.pk.resume.builder.beans.Projects"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.pk.resume.builder.dao.UserService"%>
<%@page import="org.pk.resume.builder.session.ProjectSessionConstant"%>
<%@page import="org.pk.resume.builder.constants.GlobalConstants"%>
<%@page
	import="org.pk.resume.builder.session.AchievementSessionConstant"%>
<%@page import="org.pk.resume.builder.beans.Achievements"%>
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
		ArrayList<Projects> projects =  GlobalConstants.projects;
	%>
	<jsp:include page="Menu.jsp"/>
		<fieldset>
			<legend>Achievements</legend>
			<table style="text-align: center; width: 100%;" align="center" border="1" cellspacing="0">
				<tr>
					<th>Sr No</th>
					<th>Title</th>
					<th>Front End</th>
					<th>Back End</th>
					<th>Inputs</th>
					<th>Outputs</th>
					<th>Description</th>
				</tr>

				<%
					if(projects != null && !projects.isEmpty())
					{ 
						for(int i=0; i<projects.size();i++)
						{
							Projects project = projects.get(i);
				%>
				<tr>
					<td><%=i+1%></td>
					<td><%=project.getTitte()%></td>
					<td><%=project.getFrontEnd()%></td>
					<td><%=project.getBackEnd() %></td>
					<td><%=project.getInputs()%></td>
					<td><%=project.getOutputs()%></td>
					<td><%=project.getDescription()%></td>
				</tr>
				<%
					}}
				%>
			</table>
		<br>

	<form method="post" action="AddProjects.jsp">
		<table>
			<tr>
				<td>Title of Project</td>
				<td><input type="text" name="<%=ProjectSessionConstant.TITLE%>"></td>
			</tr>
			<tr>
				<td>Guide of Project</td>
				<td><input type="text"
					name="<%=ProjectSessionConstant.GUIDE%>"></td>
			</tr>

			<tr>
				<td>Front End</td>
				<td><input type="text"
					name="<%=ProjectSessionConstant.FRONT_END%>"></td>
			</tr>
			
			<tr>
				<td>Back End</td>
				<td><input type="text"
					name="<%=ProjectSessionConstant.BACK_END%>"></td>
			</tr>
	
			<tr>
				<td>Input</td>
				<td><input type="text"
					name="<%=ProjectSessionConstant.INPUTS%>"></td>
			</tr>
			<tr>
				<td>Output</td>
				<td><input type="text"
					name="<%=ProjectSessionConstant.OUTPUTS%>"></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><input type="text"
					name="<%=ProjectSessionConstant.DESCRIPTION%>"></td>
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