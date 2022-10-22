<%@page import="java.util.ArrayList"%>
<%@page import="org.pk.resume.builder.beans.References"%>
<%@page import="org.pk.resume.builder.beans.Projects"%>
<%@page import="org.pk.resume.builder.beans.Achievements"%>
<%@page import="org.pk.resume.builder.beans.ExpertActivities"%>
<%@page import="org.pk.resume.builder.beans.Membership"%>
<%@page import="org.pk.resume.builder.beans.Participation"%>
<%@page import="org.pk.resume.builder.beans.Book"%>
<%@page import="org.pk.resume.builder.beans.Conference"%>
<%@page import="org.pk.resume.builder.beans.Journal"%>
<%@page import="org.pk.resume.builder.beans.Experience"%>
<%@page import="org.pk.resume.builder.beans.Education"%>
<%@page import="org.pk.resume.builder.beans.Personal"%>
<%@page import="org.pk.resume.builder.constants.GlobalConstants"%>
<%@page import="org.pk.resume.builder.dao.UserService"%>
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
	Personal personal = (Personal) session.getAttribute(GlobalConstants.PERSONAL_DETAILS);
	ArrayList<Education> education = GlobalConstants.educations;
	ArrayList<Experience> experience = GlobalConstants.experiences;
	ArrayList<Participation> part = GlobalConstants.participations;
	ArrayList<Achievements> achieve = GlobalConstants.achievements;
	ArrayList<Projects> project = GlobalConstants.projects;
	ArrayList<References> ref = GlobalConstants.references;
	try {
		us.insertPersonalDetails(personal);
		us.insertEducationalDetails(education);
		us.insertExperiences(experience);
		us.inserParticipation(part);
		us.insertAchievement(achieve);
		us.insertProject(project);
		us.insertReference(ref);
		GlobalConstants.MESSAGE = "Saved Successfully... Click 'Print Resume' to View Preview & Print";
	} catch(Exception ex) {
		out.println("Error in Insertion = "+ex);
		ex.printStackTrace();
		GlobalConstants.MESSAGE = "Error - "+ex+"... Try Again...";
	}
	response.sendRedirect("HomePage.jsp");
%>
</body>
</html>