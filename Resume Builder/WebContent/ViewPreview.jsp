<%@page import="org.pk.resume.builder.beans.Personal"%>
<%@page import="org.pk.resume.builder.beans.Education"%>
<%@page import="org.pk.resume.builder.beans.Experience"%>
<%@page import="org.pk.resume.builder.beans.Conference"%>
<%@page import="org.pk.resume.builder.beans.Journal"%>
<%@page import="org.pk.resume.builder.beans.Book"%>
<%@page import="org.pk.resume.builder.beans.Participation"%>
<%@page import="org.pk.resume.builder.beans.Membership"%>
<%@page import="org.pk.resume.builder.beans.ExpertActivities"%>
<%@page import="org.pk.resume.builder.beans.Achievements"%>
<%@page import="org.pk.resume.builder.beans.Projects"%>
<%@page import="org.pk.resume.builder.beans.References"%>
<%@page import="org.pk.resume.builder.constants.GlobalConstants"%>
<%@page import="org.pk.resume.builder.session.ReferencesSessionConstant"%>
<%@page import="org.apache.tomcat.jni.Global"%>

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
		References ref = new References();

		ref.setName(request.getParameter(ReferencesSessionConstant.NAME));
		ref.setDesignation(request
				.getParameter(ReferencesSessionConstant.DESIGNATION));
		ref.setAffiliation(request
				.getParameter(ReferencesSessionConstant.AFFILIATION));
		ref.setEmailId(request
				.getParameter(ReferencesSessionConstant.EMAILID));
		ref.setContactNo(request
				.getParameter(ReferencesSessionConstant.CONTACTNO));

		session.setAttribute(GlobalConstants.REFERENCES_DETAILS, ref);

		Personal personal = (Personal) session
				.getAttribute(GlobalConstants.PERSONAL_DETAILS);
		Education education = (Education) session
				.getAttribute(GlobalConstants.EDUCATIONAL_DETAILS);
		Experience experience = (Experience) session
				.getAttribute(GlobalConstants.EXPERIENCE_DETAILS);
		Journal journal = (Journal) session
				.getAttribute(GlobalConstants.JOURNAL_DETAILS);
		Conference conference = (Conference) session
				.getAttribute(GlobalConstants.CONFERENCE_DETAILS);
		Book book = (Book) session
				.getAttribute(GlobalConstants.BOOK_DETAILS);
		Participation part = (Participation) session
				.getAttribute(GlobalConstants.PARTICIPATION_DETAILS);
		Membership member = (Membership) session
				.getAttribute(GlobalConstants.MEMBERSHIP_DETAILS);
		ExpertActivities expAct = (ExpertActivities) session
				.getAttribute(GlobalConstants.EXPERT_ACTIVITY);
		Achievements achieve = (Achievements) session
				.getAttribute(GlobalConstants.ACHIEVEMENTS_DETAILS);
		Projects project = (Projects) session
				.getAttribute(GlobalConstants.PROJRCT_DETAILS);
		ref = (References) session
				.getAttribute(GlobalConstants.REFERENCES_DETAILS);
	%>

	<form action="SaveDetails.jsp" method="post">

		<fieldset>
			<legend align="center">*Personal Details*</legend>
			<table align="center" cellspacing="0">
				<tr>
					<td>Name</td>
					<td> -: <%=personal.getName()%></td>
				</tr>
				<tr>
					<td>Father Name</td>
					<td> -: <%=personal.getFatherName()%></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td> -: <%=personal.getGender()%></td>
				</tr>
				<tr>
					<td>DOB</td>
					<td> -: <%=personal.getDob()%></td>
				</tr>
				<tr>
					<td>Age</td>
					<td> -: <%=personal.getAge()%></td>
				</tr>
				<tr>
					<td>Address</td>
					<td> -: <%=personal.getAddress()%></td>
				</tr>
				<tr>
					<td>Contact</td>
					<td> -: <%=personal.getMobileNo()%></td>
				</tr>
				<tr>
					<td>Marital Status</td>
					<td> -: <%=personal.getMaritalStatus()%></td>
				</tr>
				<tr>
					<td>Mail</td>
					<td> -: <%=personal.getEmailId()%></td>
				</tr>
				<tr>
					<td>Languages known</td>
					<td> -: <%=personal.getLangaugeProf()%></td>
				</tr>
			</table>
		</fieldset>

		<fieldset>
			<legend align="center">*Educational Details*</legend>
			<table border="1" align="center" cellspacing="0">
				<tr>
					<th>SR No</th>
					<th>School/College Name</th>
					<th>Degree</th>
					<th>Subject</th>
					<th>Year</th>
					<th>Board / University</th>
					<th>obtained Marks</th>
					<th>Total Marks</th>
					<th>%</th>
				</tr>
				<tr>
					<td>1</td>
					<td><%=education.getCollegeName()%></td>
					<td><%=education.getDegree()%></td>
					<td><%=education.getSubject()%></td>
					<td><%=education.getYear()%></td>
					<td><%=education.getBoard()%></td>
					<td><%=education.getObtainedMarks()%></td>
					<td><%=education.getTotalMarks()%></td>
					<td><%=education.getPercentage()%></td>
				</tr>
			</table>
		</fieldset>

		<fieldset>
			<legend align="center">*Experience Details*</legend>
			<table align="center" border="1" cellspacing="0">
				<tr>
					<td>Employer</td>
					<td> -: <%=experience.getEmployer()%></td>
				</tr>
				<tr>
					<td>Designation</td>
					<td> -: <%=experience.getDesignation()%></td>
				</tr>
				<tr>
					<td>Joining Date</td>
					<td> -: <%=experience.getJoiningDate()%></td>
				</tr>
				<tr>
					<td>Leaving Date</td>
					<td> -:<%=experience.getLeavingDate()%></td>
				</tr>
				<tr>
					<td>Working</td>
					<td> -: <%=experience.getWorking()%></td>
				</tr>
				<tr>
					<td>experience</td>
					<td> -: <%=experience.getExperience()%></td>
				</tr>
				<tr>
					<td>Subject Taught</td>
					<td> -: <%=experience.getSubjectThaught()%></td>
				</tr>
				<tr>
					<td>Course</td>
					<td> -: <%=experience.getCourse()%></td>
				</tr>
			</table>
		</fieldset>

		<fieldset>
			<legend align="center">*Journal details*</legend>
			<table align="center" border="1" cellspacing="0">
				<tr>
					<td>Type Of Journal</td>
					<td> -: <%=journal.getPublicationType()%></td>
				</tr>
				<tr>
					<td>Name Of Journal</td>
					<td> -: <%=journal.getName()%></td>
				</tr>
				<tr>
					<td>Paper Title</td>
					<td> -: <%=journal.getPaperTitle()%></td>
				</tr>
				<tr>
					<td>Author/Author's</td>
					<td> -: <%=journal.getAuthor()%></td>
				</tr>
				<tr>
					<td>Date of Publication</td>
					<td> -: <%=journal.getPublicationDate()%></td>
				</tr>
				<tr>
					<td>Place</td>
					<td> -: <%=journal.getPlace()%></td>
				</tr>
				<tr>
					<td>Volume/Issue</td>
					<td> -:<%=journal.getVolume()%></td>
				</tr>
				<tr>
					<td>Page No.</td>
					<td> -: <%=journal.getPageNo()%></td>
				</tr>
				<tr>
					<td>DOI No.</td>
					<td> -: <%=journal.getDoiNo()%></td>
				</tr>
				<tr>
					<td>Link/URLs</td>
					<td> -:<%=journal.getLink()%></td>
				</tr>
				<tr>
					<td>Impact Factors</td>
					<td> -: <%=journal.getImpactFactor()%></td>
				</tr>
				<tr>
					<td>Type of Impact</td>
					<td> -: <%=journal.getImpactType()%></td>
				</tr>
			</table>
		</fieldset>

		<fieldset>
			<legend align="center">*Conference detail*</legend>
			<table align="center" border="1" cellspacing="0">
				<tr>
					<td>Type Of Conference</td>
					<td> -: <%=conference.getPublicationType()%></td>
				</tr>
				<tr>
					<td>Name of Conference</td>
					<td> -: <%=conference.getName()%></td>
				</tr>

				<tr>
					<td>Paper Title</td>
					<td> -: <%=conference.getPaperTitle()%></td>
				</tr>
				<tr>
					<td>Author/Author's</td>
					<td> -: <%=conference.getAuthor()%></td>
				</tr>
				<tr>
					<td>Date of Publication</td>
					<td> -: <%=conference.getPublicationDate()%></td>
				</tr>
				<tr>
					<td>Place</td>
					<td> -: <%=conference.getPlace()%></td>
				</tr>
				<tr>
					<td>Page No</td>
					<td> -: <%=conference.getPageNo()%></td>
				</tr>
				<tr>
					<td>DOI No</td>
					<td> -: <%=conference.getDoiNo()%></td>
				</tr>
				<tr>
					<td>Link/URLs</td>
					<td> -: <%=conference.getLink()%></td>
				</tr>
				<tr>
					<td>Impact Factors</td>
					<td> -: <%=conference.getImpactFactor()%></td>
				</tr>
				<tr>
					<td>Type of Impact</td>
					<td> -: <%=conference.getImpactType()%></td>
				</tr>
			</table>
		</fieldset>

		<fieldset>
			<legend align="center">*Book details*</legend>
			<table align="center" border="1" cellspacing="0">
				<tr>
					<td>Book Name</td>
					<td> -: <%=book.getBook_title()%></td>
				</tr>
				<tr>
					<td>Author</td>
					<td> -: <%=book.getAuthor()%></td>
				</tr>
				<tr>
					<td>Publisher</td>
					<td> -: <%=book.getPublisher()%></td>
				</tr>
				<tr>
					<td>ISBN No</td>
					<td> -: <%=book.getIsbn_no()%></td>
				</tr>
				<tr>
					<td>Publication Date</td>
					<td> -: <%=book.getPublication_date()%></td>
				</tr>
			</table>
		</fieldset>

		<fieldset>
			<legend align="center">*Participation Detail*</legend>
			<table align="center" border="1" cellspacing="0">
				<tr>
					<td>Name of Participation</td>
					<td> -: <%=part.getParticipation()%></td>
				</tr>
				<tr>
					<td>Duration</td>
					<td> -: <%=part.getStartDate()%> to <%=part.getEndDate()%></td>
					
				</tr>
				<tr>
					<td>Sponsored by</td>
					<td> -: <%=part.getSponsores()%></td>
				</tr>
				<tr>
					<td>Note</td>
					<td> -: <%=part.getNote()%></td>
				</tr>
				<tr>
					<td>Topic</td>
					<td> -: <%=part.getTopic()%></td>
				</tr>
				<tr>
					<td>Place</td>
					<td> -: <%=part.getPlace()%></td>
				</tr>
			</table>
		</fieldset>

		<fieldset>
			<legend align="center">*Membership Detail*</legend>
			<table align="center" border="1" cellspacing="0">
				<tr>
					<th>Sr. no.</th>
					<th>Professional Body Name</th>
					<th>Place</th>
					<th>Joining</th>
					<th>Membership Type</th>
					<th>Membership NO</th>
				</tr>
				<tr>
					<td>1</td>
					<td><%=member.getProfessionalBodyName()%></td>
					<td><%=member.getPlace()%></td>
					<td><%=member.getJoiningYear()%></td>
					<td><%=member.getMembershipType()%></td>
					<td><%=member.getMembershipNo()%></td>
				</tr>
			</table>
		</fieldset>

		<fieldset>
			<legend align="center">*Expert Role detail*</legend>
			<table align="center" border="1" cellspacing="0">
				<tr>
					<td>Expert Role</td>
					<td> -: <%=expAct.getExportRole()%></td>
				</tr>
				<tr>
					<td>Level</td>
					<td> -: <%=expAct.getLevel()%></td>
				</tr>
				<tr>
					<td>Activity Type</td>
					<td> -: <%=expAct.getActivityType()%></td>
				</tr>
				<tr>
					<td>Place</td>
					<td> -: <%=expAct.getPlace()%></td>
				</tr>
				<tr>
					<td>ISBN No</td>
					<td> -: <%=expAct.getIsbnNo()%></td>
				</tr>
			</table>
		</fieldset>

		<fieldset>
			<legend align="center">*Achievement detail*</legend>
			<table align="center" border="1" cellspacing="0">
				<tr>
					<td>Name of Achievement</td>
					<td> -: <%=achieve.getName()%></td>
				</tr>
				<tr>
					<td>Title</td>
					<td> -: <%=achieve.getTitle()%></td>
				</tr>

				<tr>
					<td>Place of Achievement</td>
					<td> -: <%=achieve.getPlace()%></td>
				</tr>

				<tr>
					<td>Date of Achievement</td>
					<td> -: <%=achieve.getDate()%></td>
				</tr>
			</table>
		</fieldset>

		<fieldset>
			<legend align="center">*Projects detail*</legend>
			<table align="center" border="1" cellspacing="0">
				<tr>
					<td>Title of Project</td>
					<td> -: <%=project.getTitte()%></td>
				</tr>
				<tr>
					<td>Guide of Project</td>
					<td> -: <%=project.getGuide()%></td>
				</tr>

				<tr>
					<td>Front End</td>
					<td> -: <%=project.getFrontEnd()%></td>
				</tr>

				<tr>
					<td>Input</td>
					<td> -: <%=project.getInputs()%></td>
				</tr>
				<tr>
					<td>Output</td>
					<td> -: <%=project.getOutputs()%></td>
				</tr>
				<tr>
					<td>Description</td>
					<td> -: <%=project.getDescription()%></td>
				</tr>
			</table>
		</fieldset>

		<fieldset>
			<legend align="center">*References*</legend>
			<table align="center" border="1"cellspacing="0">
				<tr>
					<td>Name of Reference</td>
					<td> -: <%=ref.getName()%></td>
				</tr>
				<tr>
					<td>Designation</td>
					<td> -: <%=ref.getDesignation()%></td>
				</tr>

				<tr>
					<td>Affiliation</td>
					<td> -: <%=ref.getAffiliation()%></td>
				</tr>

				<tr>
					<td>Email</td>
					<td> -: <%=ref.getEmailId()%></td>
				</tr>
				<tr>
					<td>Contact No</td>
					<td> -: <%=ref.getContactNo()%></td>
				</tr>

			</table>
		</fieldset>

		<fieldset>
			<table align="center">
				<tr>
					<td><input type="submit" name="save" value="Save"></td>
				</tr>
			</table>
		</fieldset>

	</form>
</body>
</html>