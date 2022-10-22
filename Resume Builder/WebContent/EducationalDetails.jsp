<%@page import="org.pk.resume.builder.beans.Education"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.pk.resume.builder.dao.UserService"%>
<%@page import="org.pk.resume.builder.session.EducationSession"%>
<%@page import="org.pk.resume.builder.constants.GlobalConstants"%>
<%@page import="org.apache.tomcat.jni.Global"%>
<%@page import="org.pk.resume.builder.session.PersonSession"%>
<%@page import="org.pk.resume.builder.beans.Personal"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	$(document).ready(function() {
		$("#addEdu").click(function() {
			var element = document.getElementById("tblData");
			element.appendChild("<tr></tr>");
		});
	});
</script>
<title>Home Page Resume Builder</title>
</head>
<body>
	<%
		UserService us = new UserService();
		ArrayList<Education> educations =  GlobalConstants.educations;
	%>
	
	<jsp:include page="Menu.jsp" />
	<fieldset>
		<legend> Educational Details </legend>
		<table style="text-align: center; width: 100%;" align="center"  border="1"
			cellspacing="0">
			<tr>
				<th>Sr No</th>
				<th>School/College Name</th>
				<th>Degree</th>
				<th>Subject</th>
				<th>Year</th>
				<th>Board/ University</th>
				<th>Obtained Marks</th>
				<th>Total Marks</th>
				<th>%</th>
			</tr>

			<%
				if(educations != null && !educations.isEmpty())
						{ 
							for(int i=0; i<educations.size();i++)
							{
								Education ed = educations.get(i);
			%>
			<tr>
				<td><%=i+1%></td>
				<td><%=ed.getCollegeName()%></td>
				<td><%=ed.getDegree()%></td>
				<td><%=ed.getSubject()%></td>
				<td><%=ed.getYear()%></td>
				<td><%=ed.getBoard()%></td>
				<td><%=ed.getObtainedMarks()%></td>
				<td><%=ed.getTotalMarks()%></td>
				<td><%=ed.getPercentage()%></td>
			</tr>
			<%
				}}
			%>
		</table>
		<br>
		<form action="AddNewEducation.jsp" method="post">
			<table>
				
				<tr>
					<td>School/College Name</td>
					<td><input type="text"
						name="<%=EducationSession.SCHOOL_NAME%>"
						id="<%=EducationSession.SCHOOL_NAME%>" /></td>
				</tr>
				<tr>
					<td>Degree</td>
					<td><input type="text" name="<%=EducationSession.DEGREE%>"
						id="<%=EducationSession.DEGREE%>" /></td>
				</tr>
				<tr>
					<td>Subject</td>
					<td><input type="text" name="<%=EducationSession.SUBJECT%>"
						id="<%=EducationSession.SUBJECT%>" /></td>
				</tr>
				<tr>
					<td>Year</td>
					<td><input type="text" name="<%=EducationSession.YEAR%>"
						id="<%=EducationSession.YEAR%>" /></td>
				</tr>
				<tr>
					<td>Board / University</td>
					<td><input type="text" name="<%=EducationSession.BOARD%>"
						id="<%=EducationSession.BOARD%>" /></td>
				</tr>
				<tr>
					<td>obtained Marks</td>
					<td><input type="text"
						name="<%=EducationSession.OBTAINED_MARKS%>"
						id="<%=EducationSession.OBTAINED_MARKS%>" /></td>
				</tr>
				<tr>
					<td>Total Marks</td>
					<td><input type="text"
						name="<%=EducationSession.TOTAL_MARKS%>"
						id="<%=EducationSession.TOTAL_MARKS%>" /></td>
				</tr>
				<tr>
					<td>%</td>
					<td><input type="text" name="<%=EducationSession.PERCENTAGE%>"
						id="<%=EducationSession.PERCENTAGE%>" /></td>
				</tr>

				<tr>
					<td></td>
					<td colspan="2"><input type="submit" value="Add" name="next" /></td>
					<td colspan="2"><input type="submit" value="Next" name="next" /></td>
					<td></td><td></td><td></td>
					<td colspan="2"><input type="reset" value="Reset" /></td>
				</tr>

			</table>
		</form>
	</fieldset>
</body>
</html>