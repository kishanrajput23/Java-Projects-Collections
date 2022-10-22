<%@page import="org.pk.resume.builder.session.ReferencesSessionConstant"%>
<%@page import="org.pk.resume.builder.beans.References"%>
<%@page import="org.pk.resume.builder.constants.GlobalConstants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
 	String str = request.getParameter("next");
 	if(str.equals("Add"))
 	{ 	
 		
		References ref = new References();

		ref.setName(request.getParameter(ReferencesSessionConstant.NAME));
		ref.setDesignation(request.getParameter(ReferencesSessionConstant.DESIGNATION));
		ref.setAffiliation(request.getParameter(ReferencesSessionConstant.AFFILIATION));
		ref.setEmailId(request.getParameter(ReferencesSessionConstant.EMAILID));
		ref.setContactNo(request.getParameter(ReferencesSessionConstant.CONTACTNO));

		GlobalConstants.references.add(ref);
 		response.sendRedirect("References.jsp");
 		
 	}
 	else
 	{
 		response.sendRedirect("SaveDetails.jsp");
 	}
 		
 	
 %>