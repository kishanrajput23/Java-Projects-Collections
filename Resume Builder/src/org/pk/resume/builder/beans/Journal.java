package org.pk.resume.builder.beans;

public class Journal {
	
	String name;
	String paperTitle;	
	String author;
	String publicationDate;
	String place;
	String volume;
	String pageNo;
	String doiNo;
	String link;
	String impactFactor;
	String impactType;
	String publicationType;
	
	public Journal(){}
	
	/**
	 * @param name
	 * @param paperTitle
	 * @param author
	 * @param publicationDate
	 * @param place
	 * @param volume
	 * @param pageNo
	 * @param doiNo
	 * @param link
	 * @param impactFactor
	 * @param impactType
	 * @param publicationType
	 */
	public Journal(String name, String paperTitle, String author,
			String publicationDate, String place, String volume, String pageNo,
			String doiNo, String link, String impactFactor, String impactType,
			String publicationType) {
		super();
		this.name = name;
		this.paperTitle = paperTitle;
		this.author = author;
		this.publicationDate = publicationDate;
		this.place = place;
		this.volume = volume;
		this.pageNo = pageNo;
		this.doiNo = doiNo;
		this.link = link;
		this.impactFactor = impactFactor;
		this.impactType = impactType;
		this.publicationType = publicationType;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPaperTitle() {
		return paperTitle;
	}
	
	public void setPaperTitle(String paperTitle) {
		this.paperTitle = paperTitle;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getPublicationDate() {
		return publicationDate;
	}
	
	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}
	
	public String getPlace() {
		return place;
	}
	
	public void setPlace(String place) {
		this.place = place;
	}
	
	public String getVolume() {
		return volume;
	}
	
	public void setVolume(String volume) {
		this.volume = volume;
	}
	
	public String getPageNo() {
		return pageNo;
	}
	
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	
	public String getDoiNo() {
		return doiNo;
	}
	
	public void setDoiNo(String dioNo) {
		this.doiNo = dioNo;
	}
	
	public String getLink() {
		return link;
	}
	
	public void setLink(String link) {
		this.link = link;
	}
	
	public String getImpactFactor() {
		return impactFactor;
	}
	
	public void setImpactFactor(String impactFactor) {
		this.impactFactor = impactFactor;
	}
	
	public String getImpactType() {
		return impactType;
	}
	
	public void setImpactType(String impactType) {
		this.impactType = impactType;
	}
	
	public String getPublicationType() {
		return publicationType;
	}
	
	public void setPublicationType(String publicationType) {
		this.publicationType = publicationType;
	}
		
}
