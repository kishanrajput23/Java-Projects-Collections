import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nPhone: " + phoneNumber + "\nEmail: " + email;
    }
}

public class AddressBook {
    public static void main(String[] args) {
        ArrayList<Contact> contacts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nAddress Book Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Search Contact by Name");
            System.out.println("4. Edit Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    contacts.add(new Contact(name, phoneNumber, email));
                    System.out.println("Contact added successfully!");
                    break;
                case 2:
                    System.out.println("All Contacts:");
                    for (Contact contact : contacts) {
                        System.out.println(contact);
                    }
                    break;
                case 3:
                    System.out.print("Enter Name to Search: ");
                    String searchName = scanner.nextLine();
                    for (Contact contact : contacts) {
                        if (contact.getName().equalsIgnoreCase(searchName)) {
                            System.out.println(contact);
                            break;
                        }
                    }
                    break;
                case 4:
                    // Implement editing a contact
                    break;
                case 5:
                    // Implement deleting a contact
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        }
    }
}
