
<%@page import="org.pk.resume.builder.session.AchievementSessionConstant"%>
<%@page import="org.pk.resume.builder.beans.Achievements"%>
<%@page import="org.pk.resume.builder.constants.GlobalConstants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
 	String str = request.getParameter("next");
 	if(str.equals("Add"))
 	{ 	
 		Achievements achieve = new Achievements();

		achieve.setName(request.getParameter(AchievementSessionConstant.NAME));
		achieve.setTitle(request.getParameter(AchievementSessionConstant.TITLE));
		achieve.setPlace(request.getParameter(AchievementSessionConstant.PLACE));
		achieve.setDate(request.getParameter(AchievementSessionConstant.DATE));
		GlobalConstants.achievements.add(achieve);
 		response.sendRedirect("Other_Achievement.jsp");
 	}
 	else
 	{
 		response.sendRedirect("Project.jsp");
 	}
 		
 	
 %>