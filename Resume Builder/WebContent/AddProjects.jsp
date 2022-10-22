<%@page import="org.pk.resume.builder.session.ProjectSessionConstant"%>
<%@page import="org.pk.resume.builder.constants.GlobalConstants"%>
<%@page import="org.pk.resume.builder.beans.Projects"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
 	String str = request.getParameter("next");
 	if(str.equals("Add"))
 	{ 	
 		Projects project = new Projects();
		project.setTitte(request.getParameter(ProjectSessionConstant.TITLE));
		project.setGuide(request.getParameter(ProjectSessionConstant.GUIDE));
		project.setFrontEnd(request.getParameter(ProjectSessionConstant.FRONT_END));
		project.setBackEnd(request.getParameter(ProjectSessionConstant.BACK_END));
		project.setInputs(request.getParameter(ProjectSessionConstant.INPUTS));
		project.setOutputs(request.getParameter(ProjectSessionConstant.OUTPUTS));
		project.setDescription(request.getParameter(ProjectSessionConstant.DESCRIPTION));
		GlobalConstants.projects.add(project);
 		response.sendRedirect("Project.jsp");
 	}
 	else
 	{
 		response.sendRedirect("References.jsp");
 	}
 %>