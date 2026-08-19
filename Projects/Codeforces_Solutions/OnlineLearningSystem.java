import java.util.ArrayList;
import java.util.Scanner;

public class OnlineLearningSystem {
    static class User {
        private String username, password, role;

        public User(String username, String password, String role) {
            this.username = username;
            this.password = password;
            this.role = role;
        }

        public String getUsername() {
            return username;
        }

        public boolean verifyPassword(String inputPassword) {
            return password.equals(inputPassword);
        }

        public String getRole() {
            return role;
        }
    }

    static class Course {
        private String name, description;
        private ArrayList<User> students = new ArrayList<>();
        private ArrayList<Assessment> assessments = new ArrayList<>();

        public Course(String name, String description) {
            this.name = name;
            this.description = description;
        }

        public String getName() {
            return name;
        }

        public void enroll(User student) {
            students.add(student);
        }

        public void addAssessment(Assessment assessment) {
            assessments.add(assessment);
        }

        public void displayInfo() {
            System.out.println("Course: " + name + ", Description: " + description + ", Students: " + students.size());
            assessments.forEach(a -> System.out.println("- " + a.getTitle() + ": " + a.getQuestions()));
        }
    }

    static class Assessment {
        private String title, questions;

        public Assessment(String title, String questions) {
            this.title = title;
            this.questions = questions;
        }

        public String getTitle() {
            return title;
        }

        public String getQuestions() {
            return questions;
        }
    }

    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Course> courses = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        users.add(new User("instructor1", "pass123", "instructor"));
        users.add(new User("student1", "pass123", "student"));
        users.add(new User("student2", "pass123", "student"));
        courses.add(new Course("Java Basics", "Intro to Java"));

        while (true) {
            System.out.println("1. Login\n2. New User\n3. New Course\n4. Exit\nChoose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    loginUser(scanner);
                    break;
                case 2:
                    addUser(scanner);
                    break;
                case 3:
                    addCourse(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void loginUser(Scanner scanner) {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        User user = login(username, password);
        if (user != null) {
            if (user.getRole().equals("instructor")) {
                instructorMenu(user, scanner);
            } else {
                studentMenu(user, scanner);
            }
        } else {
            System.out.println("Invalid credentials.");
        }
    }

    private static User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.verifyPassword(password)) {
                return user;
            }
        }
        return null;
    }

    private static void addUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter role (instructor/student): ");
        String role = scanner.nextLine();
        users.add(new User(username, password, role));
        System.out.println("User added successfully.");
    }

    private static void addCourse(Scanner scanner) {
        System.out.print("Enter course name: ");
        String name = scanner.nextLine();
        System.out.print("Enter course description: ");
        String description = scanner.nextLine();
        courses.add(new Course(name, description));
        System.out.println("Course added successfully.");
    }

    private static void instructorMenu(User instructor, Scanner scanner) {
        while (true) {
            System.out.println("1. View Courses\n2. Create Assessment\n3. Logout\nChoose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                courses.forEach(Course::displayInfo);
            } else if (choice == 2) {
                System.out.print("Course name: ");
                String courseName = scanner.nextLine();
                for (Course course : courses) {
                    if (course.getName().equals(courseName)) {
                        System.out.print("Assessment title: ");
                        String title = scanner.nextLine();
                        System.out.print("Assessment questions (comma-separated): ");
                        String questions = scanner.nextLine();
                        course.addAssessment(new Assessment(title, questions));
                        System.out.println("Assessment added.");
                        break;
                    }
                }
            } else if (choice == 3) {
                break;
            }
        }
    }

    private static void studentMenu(User student, Scanner scanner) {
        while (true) {
            System.out.println("1. View Courses\n2. Enroll\n3. Logout\nChoose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                courses.forEach(Course::displayInfo);
            } else if (choice == 2) {
                System.out.print("Course name: ");
                String courseName = scanner.nextLine();
                for (Course course : courses) {
                    if (course.getName().equals(courseName)) {
                        course.enroll(student);
                        System.out.println(student.getUsername() + " enrolled in " + courseName);
                        break;
                    }
                }
            } else if (choice == 3) {
                break;
            }
        }
    }
}
