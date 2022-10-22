<%@page import="org.pk.resume.builder.session.PersonSession"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="TextBox.css" />

<title>*Personal Details* - Resume Builder</title>
</head>
<body>
	<jsp:include page="Menu.jsp" />
	<fieldset>
		<legend align="center"><b>**Personal Details**</b> </legend>
		<!-- <form action="control?action=personal" method="post"> -->
		<form action="EducationalDetails.jsp" method="post">
			<table cellspacing="30px">
				<tr>
					<td>Full Name</td>
					<td><input type="text" name="<%=PersonSession.NAME%>"
						id="<%=PersonSession.NAME%>" class="textbox"
						placeholder="Name" /></td>

					<td><input type="text" name="<%=PersonSession.SURNAME%>"
						id="<%=PersonSession.SURNAME%>" class="textbox"
						placeholder="Surname" /></td>
				</tr>
				<tr>
					<td>Parent's Info.</td>
					<td><input type="text" name="<%=PersonSession.FATHER_NAME%>"
						id="<%=PersonSession.FATHER_NAME%>" class="textbox"
						placeholder="Father's Name" /></td>

					<td><input type="text" name="<%=PersonSession.MOTHER_NAME%>"
						id="<%=PersonSession.MOTHER_NAME%>" class="textbox"
						placeholder="Mother's Name" /></td>
				</tr>

				<tr>
					<td>D.O.B. </td>
					<td><input type="text" name="<%=PersonSession.DOB%>"
						id="<%=PersonSession.DOB%>" class="textbox2"
						placeholder="dd/mm/yyyy" /></td>

					<td><input type="text" name="<%=PersonSession.AGE%>"
						id="<%=PersonSession.AGE%>" class="textbox" placeholder="Age" /></td>
				</tr>

				<tr>
					<td>Gender</td>

					<td><select name="<%=PersonSession.GENDER%>"
						id="<%=PersonSession.GENDER%>" class="selectbx">
							<option>-- select --</option>
							<option value="MALE">MALE</option>
							<option value="FEMALE">FEMALE</option>
					</select>&nbsp;&nbsp;Marital Status :- </td>
					
					<td><select
						name="<%=PersonSession.MARITAL_STATUS%>"
						id="<%=PersonSession.MARITAL_STATUS%>" class="selectbx" title=""Marital Status">
							<option>-- select --</option>
							<option value="MARRIED">MARRIED</option>
							<option value="UNMARRIED">UNMARRIED</option>
					</select></td>
				</tr>

				<tr>
					<td>Contact</td>

					<td><input type="text" name="<%=PersonSession.CONTACT_NO%>"
						id="<%=PersonSession.CONTACT_NO%>" class="textbox"
						placeholder="+00-0000000000" /></td>

					<td><input type="text" name="<%=PersonSession.MAIL%>"
						id="<%=PersonSession.MAIL%>" class="textbox"
						placeholder="Mail-ID - {xyz@gmail.com}" /></td>
					<td></td>
				</tr>

				<tr>
					<td>Languages known</td>

					<td><input type="text" name="<%=PersonSession.LANGUAGES%>"
						id="<%=PersonSession.LANGUAGES%>" class="textbox" /></td>

					<td><input type="text"
						name="<%=PersonSession.NATIONALITY%>"
						id="<%=PersonSession.NATIONALITY%>" class="textbox" placeholder="Nationality {INDIAN}" /></td>
				</tr>

				<tr>
					<td>Address</td>

					<td><textarea class="textarea"
							name="<%=PersonSession.ADDRESS%>" id="<%=PersonSession.ADDRESS%>"></textarea></td>

					<td><input type="text" name="<%=PersonSession.PLACE%>"
						id="<%=PersonSession.PLACE%>" class="textbox"
						placeholder="Place" /></td>
					
				</tr>

				<tr>
					<td>Career Objectives</td>

					<td><textarea class="textarea"
							name="<%=PersonSession.CAREER_OBJECTIVES%>"
							id="<%=PersonSession.CAREER_OBJECTIVES%>"></textarea></td>
				</tr>
				<tr>
					<td>My Strengths</td>
					<td><textarea class="textarea"
							name="<%=PersonSession.STRENGTHS%>"
							id="<%=PersonSession.STRENGTHS%>"></textarea></td>
					<td></td>
				</tr>

				<tr>
					<td>Hobbies</td>
					<td><textarea class="textarea"
							name="<%=PersonSession.HOBBIES%>" id="<%=PersonSession.HOBBIES%>"></textarea></td>
					<td></td>
					<td></td>

				</tr>
				<tr>
					
					<td colspan="2">
							<center><input type="submit" value="Next" class="button" /></center></td>
					<td><input type="reset" value="Reset" class="button" /></td>
					
				</tr>

			</table>
		</form>
	</fieldset>
</body>
</html>