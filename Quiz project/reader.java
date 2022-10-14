import java.io.*;
import java.util.Scanner;

public class reader {

    static int currentQues = 0;
    static FileInputStream fis1 = null, fis2 = null;
    static Scanner sc1 = null, sc2 = null;

    //It reads the questions from Question.txt and returns the one question and its option 
    static String[] readQues() throws FileNotFoundException {
        if (currentQues == 0) {
            fis1 = new FileInputStream("Questions.txt");
            sc1 = new Scanner(fis1);
        }
        String[] list = new String[2];
        list[0] = sc1.nextLine();
        list[1] = sc1.nextLine();
        currentQues++;
        return list;
    }

    //It reads the answer of selected question from AnswerKey.txt and returns its correct option
    static String readAns() throws FileNotFoundException {
        if (currentQues == 1) {
            fis2 = new FileInputStream("AnswerKey.txt");
            sc2 = new Scanner(fis2);
        }
        String ans = sc2.nextLine();
        return ans;
    }
}