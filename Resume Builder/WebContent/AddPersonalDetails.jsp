<%@page import="org.pk.resume.builder.constants.GlobalConstants"%>
<%@page import="org.pk.resume.builder.session.PersonSession"%>
<%@page import="org.pk.resume.builder.beans.Personal"%>
<%
	Personal personal = new Personal();
	personal.setName(request.getParameter(PersonSession.NAME));
	personal.setSurname(request.getParameter(PersonSession.SURNAME));
	personal.setFatherName(request.getParameter(PersonSession.FATHER_NAME));
	personal.setMotherName(request.getParameter(PersonSession.MOTHER_NAME));
	personal.setGender(request.getParameter(PersonSession.GENDER));
	personal.setDob(request.getParameter(PersonSession.DOB));
	personal.setAge(request.getParameter(PersonSession.AGE));
	personal.setNationality(request.getParameter(PersonSession.NATIONALITY));
	personal.setAddress(request.getParameter(PersonSession.ADDRESS));
	personal.setPlace(request.getParameter(PersonSession.PLACE));
	personal.setMobileNo(request.getParameter(PersonSession.CONTACT_NO));
	personal.setMaritalStatus(request.getParameter(PersonSession.MARITAL_STATUS));
	personal.setEmailId(request.getParameter(PersonSession.MAIL));
	personal.setLangaugeProf(request.getParameter(PersonSession.LANGUAGES));
	personal.setCareerObjectives(request.getParameter(PersonSession.CAREER_OBJECTIVES));
	personal.setStrengths(request.getParameter(PersonSession.STRENGTHS));
	personal.setHobbies(request.getParameter(PersonSession.HOBBIES));
			
	session.setAttribute(GlobalConstants.PERSONAL_DETAILS, personal);
	response.sendRedirect("EducationalDetails.jsp");
		
	%>