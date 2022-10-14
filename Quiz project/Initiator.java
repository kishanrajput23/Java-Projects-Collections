import java.util.Scanner;

public class Initiator extends Thread {

    public static boolean initiator() {

        boolean flag = false;
        int countdown = 5;
        Scanner scan = new Scanner(System.in);
        while (flag == false) {

            System.out.println("!! Enter 'START' to begin the Quiz !!");

            String input = scan.nextLine();

            if (input.equals("START")) {
                System.out.print("Quiz starting in " + countdown);
                while (countdown-- > 0) {
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                    }
                    System.out.print("\b" + countdown);
                }
                System.out.println("");
                flag = true;
                return flag;
            } else {
                System.out.println(
                        "Please enter 'START' correctly. If you not want to start quiz then just enter 'QUIT'");
                String in = scan.next();
                if (in.equals("QUIT")) {
                    System.out.print("EXITING the Quiz");
                    int i = 2;
                    while (i-- > 0) {
                        for (int j = 0; j < 3; j++) {

                            System.out.print(".");
                            try {
                                Thread.sleep(700);
                            } catch (InterruptedException e) {
                            }
                            if (j == 2) {
                                System.out.print("\b\b\b");
                            }
                        }
                    }
                    return false;
                }
                if (in.equals("START")) {
                    input = "START";
                    System.out.print("Quiz starting in " + countdown);
                    while (countdown-- > 0) {
                        try {
                            Thread.sleep(1500);
                        } catch (InterruptedException e) {
                        }
                        System.out.print("\b" + countdown);
                    }
                    System.out.println("");
                    return true;

                }
            }
        }
        return true;
    }
}
