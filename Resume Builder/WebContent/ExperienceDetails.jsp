<%@page import="org.pk.resume.builder.beans.Experience"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.pk.resume.builder.dao.UserService"%>
<%@page import="org.pk.resume.builder.beans.Education"%>
<%@page import="org.pk.resume.builder.session.ExperienceSession"%>
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
		ArrayList<Experience> experiences =  GlobalConstants.experiences;
	%>
	<%
	/*Education education = new Education();
	education.setCollegeName(request.getParameter(EducationSession.SCHOOL_NAME));
	education.setDegree(request.getParameter(EducationSession.DEGREE));
	education.setSubject(request.getParameter(EducationSession.SUBJECT));
	education.setYear(request.getParameter(EducationSession.YEAR));
	education.setBoard(request.getParameter(EducationSession.BOARD));
	education.setObtainedMarks(request.getParameter(EducationSession.OBTAINED_MARKS));
	education.setTotalMarks(request.getParameter(EducationSession.TOTAL_MARKS));
	education.setPercentage(request.getParameter(EducationSession.PERCENTAGE));
	session.setAttribute(GlobalConstants.EDUCATIONAL_DETAILS, education);*/
	%>
	<jsp:include page="Menu.jsp"/>
		<fieldset>
			<legend> Experience Details </legend>
			<table style="text-align: center; width: 100%;" align="center" border="1" cellspacing="0">
				<tr>
					<th>Sr No</th>
					<th>Employer</th>
					<th>Designation</th>
					<th>Joining Date</th>
					<th>Leaving Date</th>
					<th>Working</th>
					<th>experience</th>
					<th>Subject Taught</th>
					<th>Course</th>
				</tr>

				<%
					if(experiences != null && !experiences.isEmpty())
					{ 
						for(int i=0; i<experiences.size();i++)
						{
							Experience ex = experiences.get(i);
				%>
				<tr>
					<td><%=i+1%></td>
					<td><%=ex.getEmployer()%></td>
					<td><%=ex.getDesignation()%></td>
					<td><%=ex.getJoiningDate()%></td>
					<td><%=ex.getLeavingDate()%></td>
					<td><%=ex.getWorking()%></td>
					<td><%=ex.getExperience()%></td>
					<td><%=ex.getSubjectThaught()%></td>
					<td><%=ex.getCourse()%></td>
				</tr>
				<%
					}}
				%>
			</table>
		<br>
		<form action="AddNewExperiences.jsp" method="post">
			<table>
				<tr>
					<td>Employer</td>
					<td><input type="text" name="<%=ExperienceSession.EMPLOYER %>" size="32" /></td>
				</tr>
				<tr>
					<td>Designation</td>
					<td><input type="text"
						name="<%=ExperienceSession.DESIGNATION %>" size="32" /></td>
				</tr>
				<tr>
					<td>Joining Date</td>
					<td><input type="text"
						name="<%=ExperienceSession.JOININIG_DATE %>" size="32" /></td>
				</tr>
				<tr>
					<td>Leaving Date</td>
					<td><input type="text"
						name="<%=ExperienceSession.LEAVING_DATE %>" size="32" /></td>
				</tr>
				<tr>
					<td>Working</td>
					<td><textarea rows="3" cols="25"
							name="<%=ExperienceSession.WORKING %>" ></textarea></td>
				</tr>
				<tr>
					<td>experience</td>
					<td><input type="text"
						name="<%=ExperienceSession.EXPERIENCE %>" size="32" /></td>
				</tr>
				<tr>
					<td>Subject Taught</td>
					<td><textarea rows="3" cols="25"
							name="<%=ExperienceSession.SUBJECT_THAUGHT %>"></textarea></td>
				</tr>
				<tr>
					<td>Course</td>
					<td><input type="text" name="<%=ExperienceSession.COURSE %>" size="32" /></td>
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