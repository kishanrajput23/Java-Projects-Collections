/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.information.system;

import java.awt.HeadlessException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import static student.information.system.StudentData.newWriter;

/**
 *
 * @author pawan saxena
 */
    public class ChoicesData {
    public static Writer ChoicesWriter,SortWriter;

        String cChoice1;
    String cChoice2;
    String cChoice3;
    String cChoice4;
    String cChoice5;
    String bChoice1;
    String bChoice2;
    String bChoice3;
    String bChoice4;
    String bChoice5;
    
    

    ChoicesData(String stud,String cChoice1, String cChoice2, String cChoice3, String cChoice4, String cChoice5, String bChoice1, String bChoice2, String bChoice3, String bChoice4, String bChoice5) throws HeadlessException, IOException {
        this.cChoice1 = cChoice1;
        this.cChoice2 = cChoice2;
        this.cChoice3 = cChoice3;
        this.cChoice4 = cChoice4;
        this.cChoice5 = cChoice5;
        this.bChoice1 = bChoice1;
        this.bChoice2 = bChoice2;
        this.bChoice3 = bChoice3;
        this.bChoice4 = bChoice4;
        this.bChoice5 = bChoice5;
        Store(stud);
    }

public void Store(String txt) throws IOException{
ChoicesWriter= new FileWriter("choices.txt",true);
    ChoicesWriter.write(System.lineSeparator());
        String value1 = this.cChoice1;
                String value2 = this.cChoice2;
                String value3 = this.cChoice3;
                String value4 = this.cChoice4;
                String value5 = this.cChoice5;
                String value6 = this.bChoice1;
                String value7 = this.bChoice2;
                String value8 = this.bChoice3;
                String value9= this.bChoice4;
                String value10 = this.bChoice5;
ChoicesWriter.write(txt+" Choice-1: "+value1+" Choice-2: "+value2+" Choice-3: "+value3+" Choice-4: "+value4+" Choice-5: "+value5+" Branch-Choice-1: "+value6+" Branch-Choice-2: "+value7+" Branch-Choice-3: "+value8+" Branch-Choice-4: "+value9+" Branch-Choice-5: "+value10+" ");
                 ChoicesWriter.write(System.lineSeparator());


             ChoicesWriter.flush();
             ChoicesWriter.close();

}
}
