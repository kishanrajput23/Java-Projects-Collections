/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pk.resume.builder.beans;

/**
 *
 * @author Pankaj
 */
public class Membership {
    private int id;
    private String professionalBodyName;
    private String place;
    private String joiningYear;
    private String membershipType;
    private String membershipNo;

    public Membership() {
    }

    public Membership(int id, String professionalBodyName, String place, String joiningYear, String membershipType, String membershipNo) {
        this.id = id;
        this.professionalBodyName = professionalBodyName;
        this.place = place;
        this.joiningYear = joiningYear;
        this.membershipType = membershipType;
        this.membershipNo = membershipNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfessionalBodyName() {
        return professionalBodyName;
    }

    public void setProfessionalBodyName(String professionalBodyName) {
        this.professionalBodyName = professionalBodyName;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getJoiningYear() {
        return joiningYear;
    }

    public void setJoiningYear(String joiningYear) {
        this.joiningYear = joiningYear;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public String getMembershipNo() {
        return membershipNo;
    }

    public void setMembershipNo(String membershipNo) {
        this.membershipNo = membershipNo;
    }
    
    @Override
    public String toString() {
        return "Membership { id = " + this.id + ", Professional Body Name = " + this.professionalBodyName
                + ", Place = " + this.place + ", Joining Year = " + this.joiningYear
                + ", Membership Type = " + this.membershipType + ", Membership No. = " + this.membershipNo + "}";
    }
    
}
