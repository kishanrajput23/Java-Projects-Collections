import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.*;

public class question_setter {
    public static int ques = 0;

    public static boolean set_questions() {
        Set<Integer> que = new HashSet<Integer>();

        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of Questions in Quiz: ");
        int n = s.nextInt();

        ques = n;// varaible ques contain no. of questions for Quiz

        System.out.println("Selecting qustions of " + subject_selector.subject + " ...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.print(e);
        }

        int num = 0;
        try {
            FileWriter fw1 = new FileWriter("Questions.txt");
            FileWriter fw2 = new FileWriter("AnswerKey.txt");

            while (n-- > 0) {

                boolean flag = false;

                while (!flag) {
                    num = (int) (Math.random() * 100);

                    if (num <= 30 && num % 2 == 1) {
                        if (que.contains(num)) {
                            flag = false;
                        } else {
                            que.add(num);
                            flag = true;
                        }
                    }
                }
                num--;

                for (int i = 0; i < 2; i++) {
                    String line1;
                    try (Stream<String> lines = Files.lines(Paths.get(subject_selector.subject + ".txt"))) {
                        line1 = lines.skip(num).findFirst().get();

                        fw1.write(line1 + '\n');
                    }
                    num++;
                }
                num--;
                String line2;
                try (Stream<String> lines = Files.lines(Paths.get(subject_selector.subject + "_sol" + ".txt"))) {
                    line2 = lines.skip((int) (num / 2)).findFirst().get();

                    fw2.write(line2 + '\n');
                }

                catch (IOException e) {
                    System.out.println(e);
                }

                num += 2;
            }

            fw1.close();
            fw2.close();
        }

        catch (IOException e) {
            System.out.println(e);
        }

        return true;
    }
}