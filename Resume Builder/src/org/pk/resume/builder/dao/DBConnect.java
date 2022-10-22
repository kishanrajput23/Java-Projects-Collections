package org.pk.resume.builder.dao;

import java.sql.*;
import java.util.ArrayList;

import org.pk.resume.builder.beans.Achievements;
import org.pk.resume.builder.beans.Education;
import org.pk.resume.builder.beans.Experience;
import org.pk.resume.builder.beans.Participation;
import org.pk.resume.builder.beans.Personal;
import org.pk.resume.builder.beans.Projects;
import org.pk.resume.builder.beans.References;

public class DBConnect {
	private static Connection connection = null;
	private static String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static String DATABASE_NAME = "resumebuilder";
	private static String DB_URL = "jdbc:mysql://localhost:3306/"
			+ DBConnect.DATABASE_NAME;
	private static String USER_NAME = "root";
	private static String PASSWORD = "root";

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(DRIVER_NAME);
			con = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			return con;
		} catch (ClassNotFoundException cne) {
			System.out.println(cne);
		} catch (SQLException sqle) {
			System.out.println(sqle.toString());
		}
		return con;
	}

	public void closeConnection() {
		try {

			if (connection != null)
				connection.close();
		} catch (SQLException sqle) {
			System.out.println(sqle.toString());
		}
	}

	public boolean insertPersonalDetails(Personal personal) {
		String SQL = "INSERT INTO personal_details(name, father_name, sex, dob, age, "
				+ "contact, marital_status, address, email_id,langauge_proficiencies,"
				+ "mother_name, nationality, career_objectives, strengths, hobbies, surname, place) "
				+ "VALUES('"
				+ personal.getName()
				+ "', '"
				+ personal.getFatherName()
				+ "','"
				+ personal.getGender()
				+ "','"
				+ personal.getDob()
				+ "','"
				+ personal.getAge()
				+ "','"
				+ personal.getMobileNo()
				+ "','"
				+ personal.getMaritalStatus()
				+ "','"
				+ personal.getAddress()
				+ "','"
				+ personal.getEmailId()
				+ "','"
				+ personal.getLangaugeProf()
				+ "','"
				+ personal.getMotherName()
				+ "','"
				+ personal.getNationality()
				+ "','"
				+ personal.getCareerObjectives()
				+ "','"
				+ personal.getStrengths()
				+ "','"
				+ personal.getHobbies()
				+ "','"
				+ personal.getSurname()
				+ "','"
				+ personal.getPlace()
				+ "')";

		System.out.println("SQL >> " + SQL);
		connection = getConnection();
		boolean result = Boolean.FALSE;
		try {
			if (connection != null) {
				Statement st = connection.createStatement();
				int update = st.executeUpdate(SQL);
				if (update > 0)
					result = Boolean.TRUE;
				closeConnection();
			} else {
				System.out
						.println("Connection is null in insertPersonalDetails");
			}
		} catch (SQLException sqle) {
			System.out.println("sqle in insertPersonalDetails - " + sqle);
		}
		return result;
	}
	
	public boolean insertEducationalDetails(ArrayList<Education> education) {
		for(Education edu : education)
		{
			if(!insertEducationalDetails(edu))
				return false;
		}
		return true;
	}

	public boolean insertEducationalDetails(Education education) {
		String SQL = "INSERT INTO eductional_details (name, degree, "
				+ "subject, year, board_or_university, "
				+ "obtained_marks, total_marks,percentage) "
				+ "VALUES('"
				+ education.getCollegeName()
				+ "','"
				+ education.getDegree()
				+ "','"
				+ education.getSubject()
				+ "', '"
				+ education.getYear()
				+ "','"
				+ education.getBoard()
				+ "', '"
				+ education.getObtainedMarks()
				+ "', '"
				+ education.getTotalMarks()
				+ "', '"
				+ education.getPercentage()
				+ "')";
		System.out.println("SQL >> " + SQL);
		connection = getConnection();
		boolean result = Boolean.FALSE;
		try {
			if (connection != null) {
				Statement st = connection.createStatement();
				int update = st.executeUpdate(SQL);
				if (update > 0)
					result = Boolean.TRUE;
				closeConnection();
			} else {
				System.out
						.println("Connection is null in insertEducationalDetails");
			}
		} catch (SQLException sqle) {
			System.out.println("sqle in insertEducationalDetails - " + sqle);
		}
		return result;
	}
	
	public boolean insertExperiences(ArrayList<Experience> experience) {
		for(Experience exp : experience)
		{
			if(!insertExperienceDetails(exp))
				return false;
		}
		return true;
	}

	public boolean insertExperienceDetails(Experience experience) {
		String SQL = "INSERT INTO experience (employer, designation, "
				+ "joining_date, leaving_date, work, experience) "
				+ "VALUES('"
				+ experience.getEmployer()
				+ "', '"
				+ experience.getDesignation()
				+ "', '"
				+ experience.getJoiningDate()
				+ "', '"
				+ experience.getLeavingDate()
				+ "', '"
				+ experience.getWorking()
				+ "', '"
				+ experience.getExperience()
				+ "')";
		System.out.println("SQL >> " + SQL);
		connection = getConnection();
		boolean result = Boolean.FALSE;
		try {
			if (connection != null) {
				Statement st = connection.createStatement();
				int update = st.executeUpdate(SQL);
				if (update > 0)
					result = Boolean.TRUE;
				closeConnection();
			} else {
				System.out
						.println("Connection is null in insertExperienceDetails");
			}
		} catch (SQLException sqle) {
			System.out.println("sqle in insertExperienceDetails - " + sqle);
		}
		return result;
	}
	
	public boolean insertParticipations(ArrayList<Participation> parts) {
		for(Participation part : parts)
		{
			if(!insertParticipation(part))
				return false;
		}
		return true;
	}

	public boolean insertParticipation(Participation part) {
		String SQL = "insert into participation(part_name, start_date, "
				+ "end_date, sponsores, note, topic, place)"
				+ " values( '"
				+ part.getParticipation().name()
				+ "', '"
				+ part.getStartDate()
				+ "', '"
				+ part.getEndDate()
				+ "', '"
				+ part.getSponsores()
				+ "', '"
				+ part.getNote()
				+ "','" 
				+ part.getTopic()
				+ "','"
				+ part.getPlace()
				+ "')";
		System.out.println("SQL >> " + SQL);
		boolean result = false;
		connection = getConnection();
		try {
			if (connection != null) {
				Statement st = connection.createStatement();
				int update = st.executeUpdate(SQL);
				if (update > 0) {
					result = Boolean.TRUE;
				}
				closeConnection();
			} else {
				System.out.println("Connection is null in InsertParticipation");
			}
		} catch (SQLException sqle) {
			System.out.println("sqle in InsertParticipation - " + sqle);
		}
		return result;
	}
	
	public boolean insertAchievements(ArrayList<Achievements> achievements) {
		for(Achievements achieve : achievements)
		{
			if(!insertAchievement(achieve))
				return false;
		}
		return true;
	}

	public boolean insertAchievement(Achievements achievement) {
		String SQL = "insert into achievement(name, title, place, ach_date)"
				+ " values ('"
				+ achievement.getName()
				+ "','"
				+ achievement.getTitle()
				+ "','"
				+ achievement.getPlace()
				+ "','" +
				achievement.getDate()
				+ "')";
		System.out.println("SQL >> " + SQL);
		boolean result = false;
		connection = getConnection();
		try {
			if (connection != null) {
				Statement st = connection.createStatement();
				int update = st.executeUpdate(SQL);
				if (update > 0) {
					result = Boolean.TRUE;
				}
				closeConnection();
			} else {
				System.out.println("Connection is null in insertAchievement");
			}
		} catch (SQLException sqle) {
			System.out.println("sqle in insertAchievement - " + sqle);
		}
		return result;
	}
	
	public boolean insertProjects(ArrayList<Projects> projects) {
		for(Projects project : projects)
		{
			if(!insertProject(project))
				return false;
		}
		return true;
	}


	public boolean insertProject(Projects projects) {
		String SQL = "insert into projects(title, guide,"
				+ "front_end, back_end, input, output, description)"
				+ " values('"
				+ projects.getTitte()
				+ "','"
				+ projects.getGuide()
				+ "','"
				+ projects.getFrontEnd()
				+ "','"
				+ projects.getBackEnd()
				+ "','"
				+ projects.getInputs()
				+ "','"
				+ projects.getOutputs()
				+ "','"
				+ projects.getDescription()
				+ "')";
		System.out.println("SQL >> " + SQL);
		boolean result = false;
		connection = getConnection();
		try {
			if (connection != null) {
				Statement st = connection.createStatement();
				int update = st.executeUpdate(SQL);
				if (update > 0) {
					result = Boolean.TRUE;
				}
				closeConnection();
			} else {
				System.out.println("Connection is null in insertProject");
			}
		} catch (SQLException sqle) {
			System.out.println("sqle in insertProject - " + sqle);
		}
		return result;
	}
	
	public boolean insertReferences(ArrayList<References> references) {
		for(References reference : references)
		{
			if(!insertReference(reference))
				return false;
		}
		return true;
	}

	public boolean insertReference(References reference) {
		String SQL = "insert into reference(name, designation, affilation, email, contact_no)"
				+ " values('"
				+ reference.getName()
				+ "','"
				+ reference.getDesignation()
				+ "','"
				+ reference.getAffiliation()
				+ "','"
				+ reference.getEmailId()
				+ "','"
				+ reference.getContactNo()
				+ "')";
		System.out.println("SQL >> " + SQL);
		boolean result = false;
		connection = getConnection();
		try {
			if (connection != null) {
				Statement st = connection.createStatement();
				int update = st.executeUpdate(SQL);
				if (update > 0) {
					result = Boolean.TRUE;
				}
				closeConnection();
			} else {
				System.out.println("Connection is null in insertReference");
			}
		} catch (SQLException sqle) {
			System.out.println("sqle in insertReference - " + sqle);
		}
		return result;
	}

	public Personal getPersonalDetails() {
		String SQL = "SELECT * FROM personal_details";
		System.out.println("SQL >> " + SQL);
		connection = getConnection();
		Personal result = null;
		try {
			if (connection != null) {
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(SQL);
				if (rs.next()) {
					result = new Personal();
					result.setName(rs.getString("name"));
					result.setFatherName(rs.getString("father_name"));
					result.setGender(rs.getString("sex"));
					result.setDob(rs.getString("dob"));
					result.setAge(rs.getString("age"));
					result.setMobileNo(rs.getString("contact"));
					result.setMaritalStatus(rs.getString("marital_status"));
					result.setAddress(rs.getString("address"));
					result.setEmailId(rs.getString("email_id"));
					result.setLangaugeProf(rs.getString("langauge_proficiencies"));
					result.setMotherName(rs.getString("mother_name"));
					result.setNationality(rs.getString("nationality"));
					result.setCareerObjectives(rs.getString("career_objectives"));
					result.setStrengths(rs.getString("strengths"));
					result.setHobbies(rs.getString("hobbies"));
				}
				closeConnection();
			} else {
				System.out.println("Connection is null in getPersonalDetails");
			}
		} catch (SQLException sqle) {
			System.out.println("sqle in getPersonalDetails - " + sqle);
		}
		return result;
	}

	public ArrayList<Education> getEducationalDetails() {
		String SQL = "SELECT * FROM eductional_details";
		System.out.println("SQL >> " + SQL);
		connection = getConnection();
		ArrayList<Education> results = new ArrayList<>();
		try {
			if (connection != null) {
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(SQL);
				while (rs.next()) {
					Education result = new Education();
					result.setCollegeName(rs.getString("name"));
					result.setDegree(rs.getString("degree"));
					result.setSubject(rs.getString("subject"));
					result.setYear(rs.getString("year"));
					result.setBoard(rs.getString("board_or_university"));
					result.setObtainedMarks(rs.getString("obtained_marks"));
					result.setTotalMarks(rs.getString("total_marks"));
					result.setPercentage(rs.getString("percentage"));
					results.add(result);
				}
				closeConnection();
			} else {
				System.out
						.println("Connection is null in getEducationalDetails");
			}
		} catch (SQLException sqle) {
			System.out.println("sqle in getEducationalDetails - " + sqle);
		}
		return results;
	}

	public ArrayList<Experience> getExperienceDetails() {
		String SQL = "SELECT * FROM experience";
		System.out.println("SQL >> " + SQL);
		connection = getConnection();
		ArrayList<Experience> results = new ArrayList<>();
		try {
			if (connection != null) {
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(SQL);
				while (rs.next()) {
					Experience result = new Experience();
					result.setEmployer(rs.getString("employer"));
					result.setDesignation(rs.getString("designation"));
					result.setJoiningDate(rs.getString("joining_date"));
					result.setLeavingDate(rs.getString("leaving_date"));
					result.setWorking(rs.getString("work"));
					result.setExperience(rs.getString("experience"));
					results.add(result);
				}
				closeConnection();
			} else {
				System.out
						.println("Connection is null in getExperienceDetails");
			}
		} catch (SQLException sqle) {
			System.out.println("sqle in getExperienceDetails - " + sqle);
		}
		return results;
	}

	public ArrayList<Participation> getParticipationDetails() {
		ArrayList<Participation> participation = new ArrayList<Participation>(0);
		String SQL = "select * from participation";
		connection = getConnection();
		try {
			if (connection != null) {
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(SQL);
				while (rs.next()) {

					participation.add(new Participation(
							Participation.getParticipation(
									rs.getString("part_name")), 
									rs.getString("start_date"), 
									rs.getString("end_date"), 
									rs.getString("sponsores"), 
									rs.getString("note"), 
									rs.getString("topic"),
									rs.getString("place")));

				}
				closeConnection();
			} else {
				System.out.println("Conection null in getParticipationDetails");
			}
		} catch (Exception e) {
			System.out.print("Error in getParticipationDetails - " + e);
		}

		return participation;
	}

	public ArrayList<Achievements> getAchievementDetails() {
		ArrayList<Achievements> achievementDetails = new ArrayList<>(0);
		String SQL = "select * from achievement";
		connection = getConnection();
		try {
			if (connection != null) {
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(SQL);
				while (rs.next()) {
					Achievements achieve = new Achievements();
					achieve.setName(rs.getString("name"));
					achieve.setTitle(rs.getString("title"));
					achieve.setPlace(rs.getString("place"));
					achieve.setDate(rs.getString("ach_date"));
					achievementDetails.add(achieve);
				}
				closeConnection();
			} else {
				System.out.println("Conection null in getAchievementDetails");
			}
		} catch (Exception e) {
			System.out.print("Error in getAchievementDetails- " + e);
		}

		return achievementDetails;
	}

	public ArrayList<Projects> getProjectDetails() {
		ArrayList<Projects> projectDetails = new ArrayList<>(0);
		String SQL = "select * from projects";
		connection = getConnection();
		try {
			if (connection != null) {
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(SQL);
				while (rs.next()) {
					Projects project = new Projects();
					project.setTitte(rs.getString("title"));
					project.setGuide(rs.getString("guide"));
					project.setFrontEnd(rs.getString("front_end"));
					project.setBackEnd(rs.getString("back_end"));
					project.setInputs(rs.getString("input"));
					project.setOutputs(rs.getString("output"));
					project.setDescription(rs.getString("description"));
					projectDetails.add(project);
				}
				closeConnection();
			} else {
				System.out.println("Conection null in getProjectDetails");
			}
		} catch (Exception e) {
			System.out.print("Error in getProjectDetails - " + e);
		}
		return projectDetails;
	}

	public ArrayList<References> getReferencesDetails() {

		String SQL = "SELECT * FROM reference";
		System.out.println("SQL>>" + SQL);
		ArrayList<References> referencesDetails = new ArrayList<>();
		connection = getConnection();
		try {
			if (connection != null) {
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(SQL);
				while (rs.next()) {
					References refer = new References();
					refer.setName(rs.getString("name"));
					refer.setDesignation(rs.getString("designation"));
					refer.setAffiliation(rs.getString("affilation"));
					refer.setEmailId(rs.getString("email"));
					refer.setContactNo(rs.getString("contact_no"));
					referencesDetails.add(refer);
				}
				closeConnection();
			} else {
				System.out.println("Conection null in getReferencesDetails");
			}
		} catch (Exception e) {
			System.out.print("Error in getReferencesDetails - " + e);
		}
		return referencesDetails;
	}
}
