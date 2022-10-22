package org.pk.resume.builder.dao;

import java.util.ArrayList;
import org.pk.resume.builder.beans.Achievements;
import org.pk.resume.builder.beans.Education;
import org.pk.resume.builder.beans.Experience;
import org.pk.resume.builder.beans.Participation;
import org.pk.resume.builder.beans.Personal;
import org.pk.resume.builder.beans.Projects;
import org.pk.resume.builder.beans.References;

public class UserService
{	
	private DBConnect dbConnection = new DBConnect();

	public boolean insertPersonalDetails(Personal personal){	
		return dbConnection.insertPersonalDetails(personal);
	}

	public boolean insertEducationalDetails(ArrayList<Education> education){
		return dbConnection.insertEducationalDetails(education);
	}
	
	public boolean insertExperiences(ArrayList<Experience> experience){
		return dbConnection.insertExperiences(experience);
	}
	
	public boolean inserParticipation(ArrayList<Participation> part){
        return dbConnection.insertParticipations(part);
    }
	    
    public boolean insertAchievement(ArrayList<Achievements> achievement){
    	return dbConnection.insertAchievements(achievement);
    }
    
    public boolean insertProject(ArrayList<Projects> projects){
    	return dbConnection.insertProjects(projects);
    }
    
    public boolean insertReference(ArrayList<References> reference){
    	return dbConnection.insertReferences(reference);
    }
    
	public Personal getPersonalDetails(){
		return dbConnection.getPersonalDetails();
	}
	
	public ArrayList<Education> getEducationDetails(){
		return dbConnection.getEducationalDetails();
	}
	
	public ArrayList<Experience> getExperienceDetails(){
		return dbConnection.getExperienceDetails();
	}
	
	public ArrayList<Participation> getParticipationDetails(){
        return dbConnection.getParticipationDetails();
    }
    
    public ArrayList<Achievements> getAchievementDetails(){
        return dbConnection.getAchievementDetails();
    }
    
    public ArrayList<Projects> getProjectDetails(){
        return dbConnection.getProjectDetails();
    }
    
    public ArrayList<References> getReferencesDetails(){
        return dbConnection.getReferencesDetails();
    }
}