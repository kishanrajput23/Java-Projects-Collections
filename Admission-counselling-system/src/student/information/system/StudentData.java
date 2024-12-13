/*
     * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.information.system;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import static student.information.system.Login.newWriter;

/**
 *
 * @author pawan saxena
 */
public class StudentData {
    public static Writer newWriter,SortWriter;
String firstname;
String lastname;
String dob;
String studId;
String email;
String tel;
String address;
String add2;
String apt;
String pc;
StudentData(String firstname,
String lastname,
String dob,
String studId,
String email,
String tel,
String address,
String add2,
String apt,
String pc) throws IOException, FileNotFoundException, InterruptedException {

    this.firstname=firstname;
this.lastname=lastname;
this.dob=dob;
this.studId=studId;
this.email=email;
this.tel=tel;
this.address=address;
this.add2=add2;
this.apt=apt;
this.pc=pc;
Store();
}       

public void Store() throws FileNotFoundException, IOException, InterruptedException {
    newWriter= new FileWriter("output.txt",true);
    newWriter.write(System.lineSeparator());
        String value1 = this.firstname;
                String value2 = this.lastname;
                String value3 = this.dob;
                String value4 = this.studId;
                String value5 = this.email;
                String value6 = this.tel;
                String value7 = this.address;
                String value9 = this.add2;
                String value10 = this.apt;
                String value11 = this.pc;

newWriter.write(value1+" " + value2+" "+ value3+" "+ value4+" "+ value5+" "+ value6+" "+ value7+" "+ value9+" "+ value10+" "+ value11+" ");
             

             newWriter.flush();
             newWriter.close();


    }
}
