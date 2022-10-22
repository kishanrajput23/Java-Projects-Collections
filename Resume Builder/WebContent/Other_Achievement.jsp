<%@page import="org.pk.resume.builder.beans.Achievements"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.pk.resume.builder.dao.UserService"%>
<%@page
	import="org.pk.resume.builder.session.AchievementSessionConstant"%>
<%@page
	import="org.pk.resume.builder.session.ExpertActivitySessionConstant"%>
<%@page import="org.pk.resume.builder.beans.ExpertActivities"%>
<%@page import="org.pk.resume.builder.constants.GlobalConstants"%>
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
		ArrayList<Achievements> achievements =  GlobalConstants.achievements;
	%>
	<jsp:include page="Menu.jsp"/>
		<fieldset>
			<legend>Achievements</legend>
			<table style="text-align: center; width: 100%;" align="center" border="1" cellspacing="0">
				<tr>
					<th>Sr No</th>
					<th>Name</th>
					<th>Title</th>
					<th>Place</th>
					<th>Date</th>
				</tr>

				<%
					if(achievements != null && !achievements.isEmpty())
					{ 
						for(int i=0; i<achievements.size();i++)
						{
							Achievements achieve = achievements.get(i);
				%>
				<tr>
					<td><%=i+1%></td>
					<td><%=achieve.getName()%></td>
					<td><%=achieve.getTitle()%></td>
					<td><%=achieve.getPlace()%></td>
					<td><%=achieve.getDate()%></td>
					</tr>
				<%
					}}
				%>
			</table>
		<br>
	<form method="post" action="AddAchievement.jsp">
		<table>
			<tr>
				<td>Name of Achievement</td>
				<td><input type="text"
					name="<%=AchievementSessionConstant.NAME%>"></td>
			</tr>
			<tr>
				<td>Title</td>
				<td><input type="text" name="title"></td>
			</tr>

			<tr>
				<td>Place of Achievement</td>
				<td><input type="text"
					name="<%=AchievementSessionConstant.PLACE%>"></td>
			</tr>

			<tr>
				<td>Date of Achievement</td>
				<td><input type="text"
					name="<%=AchievementSessionConstant.DATE%>"></td>
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