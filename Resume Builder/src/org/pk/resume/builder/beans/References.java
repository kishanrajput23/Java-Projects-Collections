package org.pk.resume.builder.beans;

public class References {
	private String name;
	private String designation;
	private String affiliation;
	private String emailId;
	private String contactNo;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDesignation() {
		return designation;
	}
	
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public String getAffiliation() {
		return affiliation;
	}
	
	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}
	
	public String getEmailId() {
		return emailId;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getContactNo() {
		return contactNo;
	}
	
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Override
	public String toString() {
		return "References { Name = " + this.name + ",Designation = " + this.designation
				+ ",Affiliation = " + this.affiliation + ",Email Id = " + this.emailId
				+ ",Contact No = " + this.contactNo + " } ";
	}
	
}
