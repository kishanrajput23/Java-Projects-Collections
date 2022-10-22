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
public final class Participation {

    
    
    private int id;
    //private String participationName;
    private String startDate;
    private String endDate;
    private String sponsores;
    private String note;
    private String topic;
    private String place;
    
    public enum ParticipationName {

        TRAINING, WORKSHOPS, FDP, STTP, OTHERS
    }
    public ParticipationName partName;

    
    
    public Participation() {
    }

    public Participation(ParticipationName partName, String startDate, String endDate, String sponsores, String note, String topic, String place) {
        this.setId(id);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setSponsores(sponsores);
        this.setNote(note);
        this.setTopic(topic);
        this.setPlace(place);
        this.setParticipation(partName);
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getSponsores() {
        return sponsores;
    }

    public void setSponsores(String sponsores) {
        this.sponsores = sponsores;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String Note) {
        this.note = Note;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public ParticipationName getParticipation() {
        return partName;
    }

    public void setParticipation(ParticipationName partName) {
        this.partName = partName;
    }

    public static ParticipationName getParticipation(String partName) {
        for (ParticipationName pName : ParticipationName.values()) {
            if (partName.equals(pName.name())) {
                return pName;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
        return "Participation { id = " + this.id + ",Partcipation name = " + this.partName
                + ",Start Date = " + this.startDate + ",End Date = " + this.endDate
                + ",Sponsores = " + this.sponsores + ",Note = " + this.note + ",Topic = " + this.topic
                + ",Place = " + this.place + "}";
    }
    
}
