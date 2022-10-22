package org.pk.resume.builder.beans;

public class Education {
	private int id;
	private int userId;
	private String collegeName;
	private String degree;
	private String subject;
	private String year;
	private String board;
	private String obtainedMarks;
	private String totalMarks;
	private String percentage;
	
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getBoard() {
		return board;
	}
	public void setBoard(String board) {
		this.board = board;
	}
	public String getObtainedMarks() {
		return obtainedMarks;
	}
	public void setObtainedMarks(String obtainedMarks) {
		this.obtainedMarks = obtainedMarks;
	}
	public String getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(String totalMarks) {
		this.totalMarks = totalMarks;
	}
	
	@Override
	public String toString() {
		return "Educational {id=" + this.id + ",school="+this.collegeName+", degree=" + this.degree
				+ ", subject=" + this.subject + ", year=" + this.year
				+ ", board=" + this.board + ", obtainedMarks=" + this.obtainedMarks + ", totalMarks="
				+ this.totalMarks  + " }";
	}
}
