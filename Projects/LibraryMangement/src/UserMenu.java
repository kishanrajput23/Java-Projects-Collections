
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author testuser
 */
public class UserMenu {
    public static void main(String[] args) {
        String input="";
        Scanner sc = new Scanner(System.in);
        
        while(input != "5"){
            System.out.println("---------------------------------------------------------");
            System.out.println("---------------------------------------------------------");
            System.out.println("---------------------------------------------------------");

            System.out.println("Select the following options");
            System.out.println("Enter 1 for adding a book");
            System.out.println("Enter 2 for adding a member");
            System.out.println("Enter 3 for issuing a book ");
            System.out.println("Enter 4 for returning  a book ");
            System.out.println("Enter 5 to exit");
            input = processUserInput(sc.nextLine().toString());
            
        }
    }
    public static String processUserInput(String in) {
        String retVal="5";
        switch(in){
            case "1":
                System.out.println("---------------------------------------------------------");
                System.out.println("You have selected option 1 to add a book");
                AddBookMenu.addBookMenu();
                return "1";
            case "2":
                System.out.println("---------------------------------------------------------");
                System.out.println("You have selected option 2 to add a member");
                AddMemberMenu.addMemberMenu();
                return "2";
            case "3":
                System.out.println("---------------------------------------------------------");
                System.out.println("You have selected option 3 to issue a book");
                LibFunctions.callIssueMenu();
                return "3";
            case "4":
                System.out.println("---------------------------------------------------------");
                System.out.println("You have selected option 4 to return a book");
                LibFunctions.callReturnMenu();
                return "4";
            default:
                System.out.println("---------------------------------------------------------");
                System.out.println("Thanks for working on this!!");
                return "5";
        }
        
    }
}
