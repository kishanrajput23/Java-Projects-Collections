import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private String isbn;
    private String category;
    private boolean available;

    public Book(String title, String author, String isbn, String category) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.category = category;
        this.available = true;
    }

    // Getters and setters for book details

    public boolean isAvailable() {
        return available;
    }

    public void checkOut() {
        available = false;
    }

    public void returnBook() {
        available = true;
    }
}

public class LibraryCatalogSystem {
    private static ArrayList<Book> catalog = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    searchBooks();
                    break;
                case 3:
                    viewBookDetails();
                    break;
                case 4:
                    checkoutBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Implement methods for adding, searching, viewing, checking out, and returning books

    private static void displayMenu() {
        System.out.println("\nLibrary Catalog System");
        System.out.println("1. Add a new book");
        System.out.println("2. Search books");
        System.out.println("3. View book details");
        System.out.println("4. Checkout a book");
        System.out.println("5. Return a book");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }
}
