import java.util.Scanner;

public class subject_selector {
    protected static String subject;

    static String select_subjet() {

        System.out.println("Select Subject by entering its option(1/2/3):-");
        System.out.println("1.) Programming     2.) General Knowledge     3.) Science");
        Scanner scan = new Scanner(System.in);

        int s = scan.nextInt();
        switch (s) {
        case 1:
            subject = "programming";
            break;
        case 2:
            subject = "General_knowledge";
            break;
        case 3:
            subject = "Science";
            break;
        default:
            System.out.println("Please select valid subject");
            System.exit(1);
        }
        return subject;
    }

}
