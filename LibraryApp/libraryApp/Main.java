package libraryApp;
import java.util.Scanner;

public class  Main{
	static Scanner scan = new Scanner(System.in);
    static LibraryApp app = new LibraryApp();

	
	public static void main(String[] args) {
       
		int userChoice=0;
        System.out.println("-----Welcome to the Library!-----\n");
        do{
        	System.out.println("\n-----------------------------------");
        	System.out.println("1. Search book by Title keyword.");
            System.out.println("2. Search book by ISBN number.");
            System.out.println("3. Search book by Genre.");
    		System.out.println("4. Book Check In");
    		System.out.println("5. Book Check Out");
    		System.out.println("6. Exit from the library.");
    		System.out.println("-----------------------------------");
    		System.out.print("\nChoose any option: ");
            
            userChoice = scan.nextInt();
            scan.nextLine();
            
            switch(userChoice){
            	case 1:
            			System.out.print("Enter the Title of Book: ");
            			app.findByTitle(scan.nextLine());
            			break;
            	case 2: 
            			System.out.println("Enter ISBN number: ");
            			app.findByISBN(scan.nextInt());
            			break;
            	case 3:
            			System.out.println("Enter Genre: ");
            			app.findByGenre(scan.nextLine());
            			break;
            	case 4:
            			checkIn();
            			break;
            	case 5:
            			checkOut();
            			break;
            	case 6:
            			System.out.println("\nThanks for visiting. \nSee you again.");
            			break;
            	default:
            			System.out.println("\nInvalid Choice!");	
            }    
        }while(userChoice!=6);
        
    }
    
	
		//Checking book In
    	private static void checkIn() {
    		System.out.println("Enter Book's ISBN number : ");
    		int isbnNum = scan.nextInt();
    		getStatus(isbnNum);
    		int bookAvailable = app.findISBN(isbnNum);
    		if(bookAvailable==1) {
    			System.out.println(isbnNum);
    			app.withdrawBook(isbnNum);
    			System.out.println("Book CheckIn successful.");
    			getStatus(isbnNum);
    		}
    		else
    			System.out.printf("Book with %d ISBN number not Found in inventory.",isbnNum);
    	}
    	
    	
    	//Checking book Out
    	private static void checkOut() {
    		System.out.println("\nEnter Book's ISBN number : ");
    		int isbnNum = scan.nextInt();
    		int bookAvailable = app.findISBN(isbnNum);
    		if(bookAvailable==1) {
    			if(app.depositBook(isbnNum))
    			System.out.println("Book CheckOut successful.");
    			else
    				System.out.println("No Space for more Books.");
    		}
    		else
    			System.out.printf("Book with %d ISBN number not Found in inventory.",isbnNum);
    	}
    	
    	private static void getStatus(int isbn) {
    		app.getStatus(isbn);
    	}
}