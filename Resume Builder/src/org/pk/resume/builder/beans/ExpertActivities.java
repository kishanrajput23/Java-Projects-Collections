package org.pk.resume.builder.beans;


public class ExpertActivities {
	private int id;
	private String exportRole;
	private String level;	
	private String place;
	private String isbnNo;
	
	public enum ActivityType {

        JOURNAL, CONFERENCE, WORKSHOPS
    }
    public ActivityType actName;
	
    public int getId() {
		return id;
	}
    
	public void setId(int id) {
		this.id = id;
	}
	
	public String getExportRole() {
		return exportRole;
	}
	
	public void setExportRole(String exportRole) {
		this.exportRole = exportRole;
	}
	
	public String getLevel() {
		return level;
	}
	
	public void setLevel(String level) {
		this.level = level;
	}
	
	public String getPlace() {
		return place;
	}
	
	public void setPlace(String place) {
		this.place = place;
	}
	
	public String getIsbnNo() {
		return isbnNo;
	}
	
	public void setIsbnNo(String isbnNo) {
		this.isbnNo = isbnNo;
	}
	
	public ActivityType getActivityType() {
        return actName;
    }

    public void setActivityType(ActivityType actName) {
        this.actName = actName;
    }

    public static ActivityType getActivityType(String actName) {
        for (ActivityType aName : ActivityType.values()) {
            if (actName.equals(aName.name())) {
                return aName;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
        return "Expert Activity { id = " + this.id + ",Expert Role = " + this.exportRole
                + ",Level = " + this.level + ",Activity Type = " + this.actName
                + ",Place = " + this.place + ",ISBN NO = " + this.isbnNo + " }";
    }
	

}
