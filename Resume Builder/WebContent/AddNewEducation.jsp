
<%@page import="org.pk.resume.builder.constants.GlobalConstants"%>
<%@page import="org.pk.resume.builder.beans.Education"%>
<%@page import="org.pk.resume.builder.session.EducationSession"%>
<%@page import="org.pk.resume.builder.dao.UserService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%
 	String str = request.getParameter("next");
 	if(str.equals("Add"))
 	{ 		
	 	UserService us = new UserService();
	 	Education education = new Education();
		education.setCollegeName(request.getParameter(EducationSession.SCHOOL_NAME));
		education.setDegree(request.getParameter(EducationSession.DEGREE));
		education.setSubject(request.getParameter(EducationSession.SUBJECT));
		education.setYear(request.getParameter(EducationSession.YEAR));
		education.setBoard(request.getParameter(EducationSession.BOARD));
		education.setObtainedMarks(request.getParameter(EducationSession.OBTAINED_MARKS));
		education.setTotalMarks(request.getParameter(EducationSession.TOTAL_MARKS));
		education.setPercentage(request.getParameter(EducationSession.PERCENTAGE));
		GlobalConstants.educations.add(education);
	 	response.sendRedirect("EducationalDetails.jsp");
 	}
 	else
 	{
 		response.sendRedirect("ExperienceDetails.jsp");
 	}
 		
 	
 %>