import java.util.Objects;
import java.util.Scanner;

public class Generator {
    Alphabet alphabet;
    public static Scanner keyboard;

    public Generator(Scanner scanner) {
        keyboard = scanner;
    }

    public Generator(boolean IncludeUpper, boolean IncludeLower, boolean IncludeNum, boolean IncludeSym) {
        alphabet = new Alphabet(IncludeUpper, IncludeLower, IncludeNum, IncludeSym);
    }

    public void mainLoop() {
        System.out.println("Welcome to Ziz Password Services :)");
        printMenu();

        String userOption = "-1";

        while (!userOption.equals("4")) {

            userOption = keyboard.next();

            switch (userOption) {
                case "1" -> {
                    requestPassword();
                    printMenu();
                }
                case "2" -> {
                    checkPassword();
                    printMenu();
                }
                case "3" -> {
                    printUsefulInfo();
                    printMenu();
                }
                case "4" -> printQuitMessage();
                default -> {
                    System.out.println();
                    System.out.println("Kindly select one of the available commands");
                    printMenu();
                }
            }
        }
    }

    private Password GeneratePassword(int length) {
        final StringBuilder pass = new StringBuilder("");

        final int alphabetLength = alphabet.getAlphabet().length();

        int max = alphabetLength - 1;
        int min = 0;
        int range = max - min + 1;

        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * range) + min;
            pass.append(alphabet.getAlphabet().charAt(index));
        }

        return new Password(pass.toString());
    }

    private void printUsefulInfo() {
        System.out.println();
        System.out.println("Use a minimum password length of 8 or more characters if permitted");
        System.out.println("Include lowercase and uppercase alphabetic characters, numbers and symbols if permitted");
        System.out.println("Generate passwords randomly where feasible");
        System.out.println("Avoid using the same password twice (e.g., across multiple user accounts and/or software systems)");
        System.out.println("Avoid character repetition, keyboard patterns, dictionary words, letter or number sequences," +
                "\nusernames, relative or pet names, romantic links (current or past) " +
                "and biographical information (e.g., ID numbers, ancestors' names or dates).");
        System.out.println("Avoid using information that the user's colleagues and/or " +
                "acquaintances might know to be associated with the user");
        System.out.println("Do not use passwords which consist wholly of any simple combination of the aforementioned weak components");
    }

    private void requestPassword() {
        boolean IncludeUpper = false;
        boolean IncludeLower = false;
        boolean IncludeNum = false;
        boolean IncludeSym = false;

        boolean correctParams = false;

        System.out.println();
        System.out.println("Hello, welcome to the Password Generator :) answer"
                + " the following questions by Yes or No \n");

        do {
            System.out.println("Do you want Lowercase letters \"abcd...\" to be used? ");
            String input = keyboard.nextLine();

            if (isInclude(input)) IncludeLower = true;

            System.out.println("Do you want Uppercase letters \"ABCD...\" to be used? ");
            input = keyboard.nextLine();

            if (isInclude(input)) IncludeUpper = true;

            System.out.println("Do you want Numbers \"1234...\" to be used? ");
            input = keyboard.nextLine();

            if (isInclude(input)) IncludeNum = true;

            System.out.println("Do you want Symbols \"!@#$...\" to be used? ");
            input = keyboard.nextLine();

            if (isInclude(input)) IncludeSym = true;

            //No Pool Selected
            if (!IncludeUpper && !IncludeLower && !IncludeNum && !IncludeSym) {
                System.out.println("You have selected no characters to generate your " +
                        "password at least one of your answers should be Yes");
                correctParams = true;
            }

            System.out.println("Great! Now enter the length of the password");
            int length = keyboard.nextInt();

            final Generator generator = new Generator(IncludeUpper, IncludeLower, IncludeNum, IncludeSym);
            final Password password = generator.GeneratePassword(length);

            System.err.println("Your generated password -> " + password);

        } while (correctParams);
    }

    private boolean isInclude(String Input) {
        if (Input.equalsIgnoreCase("yes")) {
            return true;
        } else {
            if (!Input.equalsIgnoreCase("no")) {
                PasswordRequestError();
            }
            return false;
        }
    }

    private void PasswordRequestError() {
        System.out.println("You have entered something incorrect let's go over it again \n");
    }

    private void checkPassword() {
        String input;
        final Scanner in = new Scanner(System.in);

        System.out.print("\nEnter your password:");
        input = in.nextLine();

        final Password p = new Password(input);

        System.out.println(p.calculateScore());

        in.close();
    }

    private void printMenu() {
        System.out.println();
        System.out.println("Enter 1 - Password Generator");
        System.out.println("Enter 2 - Password Strength Check");
        System.out.println("Enter 3 - Useful Information");
        System.out.println("Enter 4 - Quit");
        System.out.print("Choice:");
    }

    private void printQuitMessage() {
        System.out.println("Closing the program bye bye!");
    }
}
