import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Note {
    private String title;
    private String content;

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Getters and setters for note details
}

public class NotesApp {
    private static ArrayList<Note> notes = new ArrayList<>();
    private static final String FILENAME = "notes.txt"; // File to save notes
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loadNotes(); // Load saved notes from the file

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    createNote();
                    break;
                case 2:
                    viewNotes();
                    break;
                case 3:
                    editNote();
                    break;
                case 4:
                    deleteNote();
                    break;
                case 5:
                    saveNotes(); // Save notes to the file
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Implement methods for creating, viewing, editing, and deleting notes

    private static void displayMenu() {
        System.out.println("\nNotes Keeping App");
        System.out.println("1. Create a new note");
        System.out.println("2. View saved notes");
        System.out.println("3. Edit a note");
        System.out.println("4. Delete a note");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void loadNotes() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 2) {
                    notes.add(new Note(parts[0], parts[1]));
                }
            }
        } catch (IOException e) {
            // Handle file loading errors, or create the file if it doesn't exist
        }
    }

    private static void saveNotes() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
            for (Note note : notes) {
                writer.println(note.getTitle() + "|" + note.getContent());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
