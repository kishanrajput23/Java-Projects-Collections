/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalyearproject;

/**
 *
 * @author Prof Oyondi
 */
public class StudentInfo {
    private int id;
    private String name;
    private int hwScore;
    private int tScore;
    
    private int sTotal;
    private String sGrade;
    //constructor to get student data values from the database
    StudentInfo(int stude_id, String sName, int homework, int test, int Total, String Grades) {
        this.id = stude_id;
        this.name = sName;
        this.hwScore = homework;
        this.tScore = test;
        this.sTotal = Total;
        this.sGrade = Grades;
    }
    //Encapsulation applied here
    public int getSID()
    {
        //returns student id
        return id;
    }
    public String getSName()
    {
        //returns student name
        return name;
    }
    public int getHScore()
    {
        //returns homework score
        return hwScore;
    }
    public int getSTest()
    {
        //returns student test score
        return tScore;
    }
    public int getTotals()
    {
        return sTotal;
    }
    public String getSGrade()
    {
        return sGrade;
    }
}
