<%@page import="org.pk.resume.builder.beans.Participation"%>
<%@page import="org.pk.resume.builder.session.ParticipationSessionConstant"%>
<%@page import="org.pk.resume.builder.constants.GlobalConstants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
 	String str = request.getParameter("next");
 	if(str.equals("Add"))
 	{ 	
 		Participation part = new Participation();

		part.setId(1);
		part.setParticipation(Participation.getParticipation(request
				.getParameter(ParticipationSessionConstant.PARTICIPATION)));
		part.setStartDate(request
				.getParameter(ParticipationSessionConstant.START_DATE));
		part.setEndDate(request
				.getParameter(ParticipationSessionConstant.END_DATE));
		part.setSponsores(request
				.getParameter(ParticipationSessionConstant.SPONSOR));
		part.setNote(request
				.getParameter(ParticipationSessionConstant.NOTE));
		part.setTopic(request
				.getParameter(ParticipationSessionConstant.TOPIC));
		part.setPlace(request
				.getParameter(ParticipationSessionConstant.PLACE));
 		
		GlobalConstants.participations.add(part);
 	response.sendRedirect("ParticipationDetails.jsp");
 	}
 	else
 	{
 		response.sendRedirect("Other_Achievement.jsp");
 	}
 		
 	
 %>