import java.util.Scanner;

class Book {
    public int sNo;
    public String bookName;
    public String authorName;
    public int bookQty;
    public int bookQtyCopy;

    Scanner input = new Scanner(System.in);

    public Book() {
        System.out.println("Enter Serial No of Book:");
        this.sNo = input.nextInt();
        input.nextLine();

        System.out.println("Enter Book Name:");
        this.bookName = input.nextLine();

        System.out.println("Enter Author Name:");
        this.authorName = input.nextLine();

        System.out.println("Enter Quantity of Books:");
        this.bookQty = input.nextInt();
        bookQtyCopy = this.bookQty;
    }
}

class Student {
    String studentName;
    String regNum;

    Book borrowedBooks[] = new Book[3];
    public int booksCount = 0;

    Scanner input = new Scanner(System.in);

    public Student() {
        System.out.println("Enter Student Name:");
        this.studentName = input.nextLine();

        System.out.println("Enter Registration Number:");
        this.regNum = input.nextLine();
    }
}

class Books {
    private Book[] theBooks = new Book[50];
    private int count;
    private Scanner input = new Scanner(System.in);

    public int compareBookObjects(Book b1, Book b2) {
        if (b1.bookName.equalsIgnoreCase(b2.bookName)) {
            System.out.println("Book of this Name Already Exists.");
            return 0;
        }
        if (b1.sNo == b2.sNo) {
            System.out.println("Book of this Serial No Already Exists.");
            return 0;
        }
        return 1;
    }

    public void addBook(Book b) {
        for (int i = 0; i < count; i++) {
            if (compareBookObjects(b, theBooks[i]) == 0)
                return;
        }
        if (count < 50) {
            theBooks[count] = b;
            count++;
        } else {
            System.out.println("No Space to Add More Books.");
        }
    }

    public void searchBySno() {
        System.out.println("\t\t\t\tSEARCH BY SERIAL NUMBER\n");
        System.out.println("Enter Serial No of Book:");
        int sNo = input.nextInt();
        int flag = 0;
        System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
        for (int i = 0; i < count; i++) {
            if (sNo == theBooks[i].sNo) {
                System.out.println(
                    theBooks[i].sNo + "\t\t"
                    + theBooks[i].bookName + "\t\t"
                    + theBooks[i].authorName + "\t\t"
                    + theBooks[i].bookQtyCopy + "\t\t"
                    + theBooks[i].bookQty);
                flag++;
                return;
            }
        }
        if (flag == 0)
            System.out.println("No Book for Serial No " + sNo + " Found.");
    }

    public void searchByAuthorName() {
        System.out.println("\t\t\t\tSEARCH BY AUTHOR'S NAME");
        input.nextLine();
        System.out.println("Enter Author Name:");
        String authorName = input.nextLine();
        int flag = 0;
        System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
        for (int i = 0; i < count; i++) {
            if (authorName.equalsIgnoreCase(theBooks[i].authorName)) {
                System.out.println(
                    theBooks[i].sNo + "\t\t"
                    + theBooks[i].bookName + "\t\t"
                    + theBooks[i].authorName + "\t\t"
                    + theBooks[i].bookQtyCopy + "\t\t"
                    + theBooks[i].bookQty);
                flag++;
            }
        }
        if (flag == 0)
            System.out.println("No Books of " + authorName + " Found.");
    }

    public void showAllBooks() {
        System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
        System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
        for (int i = 0; i < count; i++) {
            System.out.println(
                theBooks[i].sNo + "\t\t"
                + theBooks[i].bookName + "\t\t"
                + theBooks[i].authorName + "\t\t"
                + theBooks[i].bookQtyCopy + "\t\t"
                + theBooks[i].bookQty);
        }
    }

    public void upgradeBookQty() {
        System.out.println("\t\t\t\tUPGRADE QUANTITY OF A BOOK\n");
        System.out.println("Enter Serial No of Book");
        int sNo = input.nextInt();
        for (int i = 0; i < count; i++) {
            if (sNo == theBooks[i].sNo) {
                System.out.println("Enter No of Books to be Added:");
                int addingQty = input.nextInt();
                theBooks[i].bookQty += addingQty;
                theBooks[i].bookQtyCopy += addingQty;
                return;
            }
        }
    }

    public int isAvailable(int sNo) {
        for (int i = 0; i < count; i++) {
            if (sNo == theBooks[i].sNo) {
                if (theBooks[i].bookQtyCopy > 0) {
                    System.out.println("Book is Available.");
                    return i;
                }
                System.out.println("Book is Unavailable");
                return -1;
            }
        }
        System.out.println("No Book of Serial Number Available in Library.");
        return -1;
    }

    public Book checkOutBook() {
        System.out.println("Enter Serial No of Book to be Checked Out.");
        int sNo = input.nextInt();
        int bookIndex = isAvailable(sNo);
        if (bookIndex != -1) {
            theBooks[bookIndex].bookQtyCopy--;
            return theBooks[bookIndex];
        }
        return null;
    }

    public void checkInBook(Book b) {
        for (int i = 0; i < count; i++) {
            if (b.equals(theBooks[i])) {
                theBooks[i].bookQtyCopy++;
                return;
            }
        }
    }
}

class Students {
    Scanner input = new Scanner(System.in);
    student theStudents[] = new student[50];
    public static int count = 0;

    public void addStudent(student s) {
        for (int i = 0; i < count; i++) {
            if (s.regNum.equalsIgnoreCase(theStudents[i].regNum)) {
                System.out.println("Student of Reg Num " + s.regNum + " is Already Registered.");
                return;
            }
        }

        if (count <= 50) {
            theStudents[count] = s;
            count++;
        }
    }

    public void showAllStudents() {
        System.out.println("Student Name\t\tReg Number");
        for (int i = 0; i < count; i++) {
            System.out.println(theStudents[i].studentName + "\t\t" + theStudents[i].regNum);
        }
    }

    public int isStudent() {
        System.out.println("Enter Reg Number:");
        String regNum = input.nextLine();

        for (int i = 0; i < count; i++) {
            if (theStudents[i].regNum.equalsIgnoreCase(regNum)) {
                return i;
            }
        }

        System.out.println("Student is not Registered.");
        System.out.println("Get Registered First.");
        return -1;
    }

    public void checkOutBook(Books book) {
        int studentIndex = this.isStudent();

        if (studentIndex != -1) {
            System.out.println("checking out");
            book.showAllBooks();
            book b = book.checkOutBook();
            System.out.println("checking out");

            if (b != null) {
                if (theStudents[studentIndex].booksCount <= 3) {
                    System.out.println("adding book");
                    theStudents[studentIndex].borrowedBooks[theStudents[studentIndex].booksCount] = b;
                    theStudents[studentIndex].booksCount++;
                    return;
                } else {
                    System.out.println("Student Can not Borrow more than 3 Books.");
                    return;
                }
            }
            System.out.println("Book is not Available.");
        }
    }

    public void checkInBook(Books book) {
        int studentIndex = this.isStudent();
        if (studentIndex != -1) {
            System.out.println("S.No\t\t\tBook Name\t\t\tAuthor Name");
            student s = theStudents[studentIndex];

            for (int i = 0; i < s.booksCount; i++) {
                System.out.println(
                    s.borrowedBooks[i].sNo + "\t\t\t"
                    + s.borrowedBooks[i].bookName + "\t\t\t"
                    + s.borrowedBooks[i].authorName);
            }

            System.out.println("Enter Serial Number of Book to be Checked In:");
            int sNo = input.nextInt();

            for (int i = 0; i < s.booksCount; i++) {
                if (sNo == s.borrowedBooks[i].sNo) {
                    book.checkInBook(s.borrowedBooks[i]);
                    s.borrowedBooks[i] = null;
                    return;
                }
            }

            System.out.println("Book of Serial No " + sNo + " not Found");
        }
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Books books = new Books();
        Students students = new Students();

        int choice;

        do {
            System.out.println("Library System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Add Book");
            System.out.println("3. Search Book by Serial Number");
            System.out.println("4. Search Book by Author Name");
            System.out.println("5. Show All Books");
            System.out.println("6. Upgrade Quantity of a Book");
            System.out.println("7. Check Out Book");
            System.out.println("8. Check In Book");
            System.out.println("9. Show All Students");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    student newStudent = new student();
                    students.addStudent(newStudent);
                    break;
                case 2:
                    Book newBook = new Book();
                    books.addBook(newBook);
                    break;
                case 3:
                    books.searchBySno();
                    break;
                case 4:
                    books.searchByAuthorName();
                    break;
                case 5:
                    books.showAllBooks();
                    break;
                case 6:
                    books.upgradeBookQty();
                    break;
                case 7:
                    students.checkOutBook(books);
                    break;
                case 8:
                    students.checkInBook(books);
                    break;
                case 9:
                    students.showAllStudents();
                    break;
                case 0:
                    System.out.println("Exiting Library System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);
    }
}
