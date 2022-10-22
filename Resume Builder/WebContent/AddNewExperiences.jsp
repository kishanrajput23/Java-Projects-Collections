
<%@page import="org.pk.resume.builder.constants.GlobalConstants"%>
<%@page import="org.pk.resume.builder.session.ExperienceSession"%>
<%@page import="org.pk.resume.builder.beans.Experience"%>
<%@page import="org.pk.resume.builder.dao.UserService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
 	String str = request.getParameter("next");
 	if(str.equals("Add"))
 	{ 		
 		Experience experience = new Experience();
		experience.setEmployer(request.getParameter(ExperienceSession.EMPLOYER));
		experience.setDesignation(request.getParameter(ExperienceSession.DESIGNATION));
		experience.setJoiningDate(request.getParameter(ExperienceSession.JOININIG_DATE));
		experience.setLeavingDate(request.getParameter(ExperienceSession.LEAVING_DATE));
		experience.setWorking(request.getParameter(ExperienceSession.WORKING));
		experience.setSubjectThaught(request.getParameter(ExperienceSession.SUBJECT_THAUGHT));
		experience.setCourse(request.getParameter(ExperienceSession.COURSE));
		experience.setExperience(request.getParameter(ExperienceSession.EXPERIENCE));
		GlobalConstants.experiences.add(experience);
 	response.sendRedirect("ExperienceDetails.jsp");
 	}
 	else
 	{
 		response.sendRedirect("ParticipationDetails.jsp");
 	}
 		
 	
 %>