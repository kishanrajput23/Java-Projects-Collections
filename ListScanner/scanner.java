import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {
    private static ArrayList<Task> taskList = new ArrayList<>();
    private static int taskIdCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("To-Do List Application");
            System.out.println("1. Add Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Remove Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    listTasks();
                    break;
                case 3:
                    markTaskAsCompleted(scanner);
                    break;
                case 4:
                    removeTask(scanner);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addTask(Scanner scanner) {
        System.out.print("Enter the task description: ");
        String description = scanner.nextLine();
        Task task = new Task(taskIdCounter, description);
        taskList.add(task);
        taskIdCounter++;
        System.out.println("Task added successfully!");
    }

    private static void listTasks() {
        if (taskList.isEmpty()) {
            System.out.println("No tasks to display.");
        } else {
            System.out.println("Tasks:");
            for (Task task : taskList) {
                System.out.println(task);
            }
        }
    }

    private static void markTaskAsCompleted(Scanner scanner) {
        System.out.print("Enter the task ID to mark as completed: ");
        int taskId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        for (Task task : taskList) {
            if (task.getId() == taskId) {
                task.setCompleted(true);
                System.out.println("Task marked as completed.");
                return;
            }
        }
        System.out.println("Task not found.");
    }

    private static void removeTask(Scanner scanner) {
        System.out.print("Enter the task ID to remove: ");
        int taskId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        for (Task task : taskList) {
            if (task.getId() == taskId) {
                taskList.remove(task);
                System.out.println("Task removed.");
                return;
            }
        }
        System.out.println("Task not found.");
    }
}

class Task {
    private int id;
    private String description;
    private boolean completed;

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        this.completed = false;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return id + ". [" + (completed ? "X" : " ") + "] " + description;
    }
}
