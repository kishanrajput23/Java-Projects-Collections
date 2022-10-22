<%@page import="org.pk.resume.builder.beans.References"%>
<%@page import="org.pk.resume.builder.beans.Projects"%>
<%@page import="org.pk.resume.builder.beans.Achievements"%>
<%@page import="org.pk.resume.builder.beans.ExpertActivities"%>
<%@page import="org.pk.resume.builder.beans.Membership"%>
<%@page import="org.pk.resume.builder.beans.Participation"%>
<%@page import="org.pk.resume.builder.beans.Book"%>
<%@page import="org.pk.resume.builder.beans.Conference"%>
<%@page import="org.pk.resume.builder.beans.Journal"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.pk.resume.builder.dao.UserService"%>
<%@page import="org.pk.resume.builder.session.ExperienceSession"%>
<%@page import="org.pk.resume.builder.beans.Experience"%>
<%@page import="org.pk.resume.builder.session.EducationSession"%>
<%@page import="org.pk.resume.builder.beans.Education"%>
<%@page import="org.pk.resume.builder.constants.GlobalConstants"%>
<%@page import="org.apache.tomcat.jni.Global"%>
<%@page import="org.pk.resume.builder.beans.Personal"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>*Preview and Prints* - Resume Builder</title>
</head>
<body bgcolor="lightgray">

	<%
		UserService us = new UserService();
			
			Personal personal = us.getPersonalDetails();
			System.out.println(personal);
			ArrayList<Education> educations = us.getEducationDetails();
			ArrayList<Experience> experiences = us.getExperienceDetails();
			ArrayList<Participation> participations = us.getParticipationDetails();
			ArrayList<Achievements> achievements = us.getAchievementDetails();
			ArrayList<Projects> projects = us.getProjectDetails();
			ArrayList<References> refers = us.getReferencesDetails();
	%>
	<form action="control?action=resume" method="post">
		<fieldset>
			<center>
				<h2>RESUME</h2>
			</center>
			<hr width="200" class="border">
			
				<center>
					<h4>Personal Info</h4>
				</center>
				<hr class="border">
				<table align="center" >
					<tr>
						<td><b>Mr. <%=personal.getName()%></b></td>
					</tr>
					
					<tr>
						<td><%=personal.getAddress()%></td>
					</tr>
					<tr>
						<td>Contact no :- <%=personal.getMobileNo()%></td>
					</tr>
					<tr>
						<td>Mail id :- <%=personal.getEmailId()%></td>
					</tr>

					<tr>
						<td>D.O.B :- <%=personal.getDob()%></td>
					</tr>
					<tr>
						<td>Languages known :- <%=personal.getLangaugeProf()%></td>
					</tr>
				</table>
			
			<hr class="border">
			<h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Career Objectives</h4>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<%=personal.getCareerObjectives() %>
			<hr class="border">
			<h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;My Strength's</h4>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<%=personal.getStrengths() %>
			<!-- <hr width="150" style="border-width: thick;">--><br><br>
			<fieldset>
				<center>
					<h4>Educational Info</h4>
				</center>
				<hr class="border">
				<%
					for (int i = 0; i < educations.size(); i++) {
										Education education = educations.get(i);
				%>

				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><%=i+1%>)
					Year <%=education.getYear()%></b> <br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<b>Education :-</b>
				<%=education.getDegree()%>
				In
				<%=education.getSubject()%>
				<br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<b>Institute :-</b>
				<%=education.getCollegeName()%>
				<br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<b>University :-</b>
				<%=education.getBoard()%>
				<br>
				<table border="1" id="tblData" cellspacing="0" align="center">
					<tr>
						<th>obtained Marks</th>
						<th>Total Marks</th>
						<th>Percentage</th>
					</tr>
					<tr>
						<td><%=education.getObtainedMarks()%></td>
						<td><%=education.getTotalMarks()%></td>
						<td><%=education.getPercentage()%></td>
					</tr>

				</table>
				<%
					}
				%>
			</fieldset>
			<fieldset>
				<center>
					<h4>My Experience</h4>
				</center>
				<hr class="border">
				<h4>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<u>Employment Details</u>
				</h4>
				<%
					for (int i = 0; i < experiences.size(); i++) {
										Experience experience = experiences.get(i);
				%>


				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><%=i+1%>)
					<%=experience.getEmployer()%></b><br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Designation
					:- </b>
				<%=experience.getDesignation()%>
				<br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Experience
					:- </b>
				<%=experience.getExperience()%>
				<br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Joining
					at :- </b>
				<%=experience.getJoiningDate()%>
				To
				<%=experience.getLeavingDate()%>
				<br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Working
					:- </b>
				<%=experience.getWorking()%>
				<br>
				<%
					}
				%>

			</fieldset>
			<fieldset>
				<center>
					<h4>My Participation</h4>
				</center>
				<hr class="border">
				<%
					for (int i = 0; i < participations.size(); i++) {
										Participation part = participations.get(i);
				%>

				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><%=i+1%>)
					<%=part.getTopic()%></b><br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Type
					:- </b>
				<%=part.getParticipation()%>
				<br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Sponsors
					:- </b>
				<%=part.getSponsores()%>
				<br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Place
					:- </b>
				<%=part.getPlace()%>
				<br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>About
					:- </b>
				<%=part.getNote()%>
				<br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Date
					attended :- </b>
				<%=part.getStartDate()%>
				To
				<%=part.getEndDate()%>
				<br>
				<%
					}
				%>
			</fieldset>

			<fieldset>
				<center>
					<h4>Projects</h4>
				</center>
				<hr class="border">
				<%
					for (int i = 0; i < projects.size(); i++) {
										Projects project = projects.get(i);
				%>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><%=i+1%>)
					<%=project.getTitte()%> </b><br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Front-End
					:- </b>
				<%=project.getFrontEnd()%>
				<br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Inputs
					:- </b>
				<%=project.getInputs()%>
				<br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Outputs
					:- </b>
				<%=project.getOutputs()%>
				<br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>About
					:- </b>
				<%=project.getDescription()%>
				<br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Guide
					:- </b>
				<%=project.getGuide()%>
				<br>

				<%
					}
				%>
			</fieldset>

			<fieldset>
				<center>
					<h4>Achievements</h4>
				</center>
				<hr class="border">
				<%
					for (int i = 0; i < achievements.size(); i++) {
										Achievements achieve = achievements.get(i);
				%>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><%=i+1%>)
					<%=achieve.getTitle()%> for <%=achieve.getName()%> </b><br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Place
					:- </b>
				<%=achieve.getPlace()%>
				<br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Date
					:- </b>
				<%=achieve.getDate()%>
				<br>
				<%
					}
				%>
			</fieldset>

			<fieldset>
				<center>
					<h4>References</h4>
				</center>
				<hr class="border">
				<%
					for (int i = 0; i < refers.size(); i++) {
										References ref = refers.get(i);
				%>

				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><%=i+1%>)
					<%=ref.getName()%> </b><br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Designation
					:- </b>
				<%=ref.getDesignation()%>
				<br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Affiliation
					:- </b>
				<%=ref.getAffiliation()%>
				<br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Contact
					no. :- </b>
				<%=ref.getContactNo()%>
				<br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Email
					id :- </b>
				<%=ref.getEmailId()%>
				<br>
				<%
					}
				%>
			</fieldset>
			<fieldset>
				<center>
					<h4>Personal Info</h4>
				</center>
				<hr class="border"">
				<table align="center">
					<tr>
						<td>Father Name :- <%=personal.getFatherName()%></td>
					</tr>
					
					<tr>
						<td>Mother Name :- <%=personal.getMotherName()%></td>
					</tr>

					<tr>
						<td>Gender :- <%=personal.getGender()%></td>
					</tr>

					<tr>
						<td>D.O.B :- <%=personal.getDob()%></td>
					</tr>
					
					<tr>
						<td>Age :- <%=personal.getAge()%></td>
					</tr>

					<tr>
						<td>Marital :- <%=personal.getMaritalStatus()%>

					<tr>
						<td>Nationality :- <%=personal.getNationality()%></td>
					</tr>
					
					<tr>
						<td>Hobbies :- <%=personal.getHobbies()%></td>
					</tr>
				</table>
			</fieldset>
		</fieldset>
	</form>
	<center>
		<input type="button" onClick="window.print()"
			value="Print Your Resume" />
	</center>
</body>
</html>