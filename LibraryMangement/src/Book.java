/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author testuser
 */
public class Book {
    private String isbnCode;
    private String bookName;
    private String bookDesc;
    private String authorName;
    private String subjectName;
    private Integer unitsAvailable;
    
    public Book(){
        
    }
    public Book(String isbnCode, String bookName, String bookDesc, String authorName, String subjectName, Integer unitsAvailable) {
        this.isbnCode = isbnCode;
        this.bookName = bookName;
        this.bookDesc = bookDesc;
        this.authorName = authorName;
        this.subjectName = subjectName;
        this.unitsAvailable = unitsAvailable;
    }

    public Integer getUnitsAvailable() {
        return unitsAvailable;
    }

    public void setUnitsAvailable(Integer unitsAvailable) {
        this.unitsAvailable = unitsAvailable;
    }

    public String getIsbnCode() {
        return isbnCode;
    }

    public void setIsbnCode(String isbnCode) {
        this.isbnCode = isbnCode;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }


}
