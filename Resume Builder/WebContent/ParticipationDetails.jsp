<%@page import="java.util.ArrayList"%>
<%@page import="org.pk.resume.builder.dao.UserService"%>
<%@page import="org.pk.resume.builder.constants.GlobalConstants"%>
<%@page import="org.pk.resume.builder.session.BookSessionConstant"%>
<%@page import="org.pk.resume.builder.beans.Book"%>
<%@page import="org.pk.resume.builder.session.ParticipationSessionConstant"%>
<%@page import="org.pk.resume.builder.beans.Participation.ParticipationName"%>
<%@page import="org.pk.resume.builder.beans.Participation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Participation</title>
</head>
<body>
	<%
		UserService us = new UserService();
		ArrayList<Participation> part =  GlobalConstants.participations;
	%>
	<jsp:include page="Menu.jsp"/>
		<fieldset>
			<legend>Participation Details</legend>
			<table style="text-align: center; width: 100%;" align="center" border="1" cellspacing="0">
				<tr>
					<th>Sr No</th>
					<th>Name</th>
					<th>Start Date</th>
					<th>Ending Date</th>
					<th>Sponsors</th>
					<th>Topic</th>
					<th>Note</th>
					<th>Place</th>
				</tr>

				<%
					if(part != null && !part.isEmpty())
					{ 
						for(int i=0; i<part.size();i++)
						{
							Participation parts = part.get(i);
				%>
				<tr>
					<td><%=i+1%></td>
					<td><%=parts.getParticipation()%></td>
					<td><%=parts.getStartDate()%></td>
					<td><%=parts.getEndDate()%></td>
					<td><%=parts.getSponsores()%></td>
					<td><%=parts.getTopic()%></td>
					<td><%=parts.getNote()%></td>
					<td><%=parts.getPlace()%></td>
				</tr>
				<%
					}}
				%>
			</table>
		<br>
			<form method="post" action="AddNewParticipation.jsp">
			<table>
				<tr>
					<td>Name of Participation :-</td>
					<td><select
						name="<%=ParticipationSessionConstant.PARTICIPATION%>">
							<%
								for(Participation.ParticipationName p : ParticipationName.values()){
							%>
							<option value="<%=p.name()%>">
								<%=p.name()%>
							</option>
							<%
								}
							%>
					</select></td>
				</tr>
				<tr>
					<td>Duration :-</td>
					<td><input type="text"
						name="<%=ParticipationSessionConstant.START_DATE%>"></td>
					<td>To</td>
					<td><input type="text"
						name="<%=ParticipationSessionConstant.END_DATE%>"></td>
				</tr>
				<tr>
					<td>Sponsored by :-</td>
					<td><input type="text"
						name="<%=ParticipationSessionConstant.SPONSOR%>"></td>
				</tr>
				<tr>
					<td>Note :-</td>
					<td><textarea name="<%=ParticipationSessionConstant.NOTE%>"></textarea>
					</td>
				</tr>
				<tr>
					<td>Topic :-</td>
					<td><input type="text"
						name="<%=ParticipationSessionConstant.TOPIC%>"></td>
				</tr>
				<tr>
					<td>Place :-</td>
					<td><input type="text"
						name="<%=ParticipationSessionConstant.PLACE%>"></td>
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