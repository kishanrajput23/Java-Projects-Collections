package Task_Tracker;
import java.util.Scanner;
import java.util.List;

public class TaskTrackerApp {
    public static void main(String[] args) {
        TaskTracker taskTracker = new TaskTracker();
        TaskConsoleView taskView = new TaskConsoleView();
        Scanner scanner = new Scanner(System.in); // Input handling primarily here

        while (true) {
            taskView.displayMenu();

            int choice = -1;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                taskView.showMessage("Invalid input. Please enter a number.");
                scanner.next(); // Consume invalid input
                continue; // Go back to the start of the loop
            }
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    taskView.showMessage(taskView.getTaskDescriptionPrompt()); // Show prompt via view
                    String description = scanner.nextLine();
                    if (taskTracker.addTask(description)) {
                        taskView.showMessage("Task added: " + description);
                    } else {
                        // This case might be relevant if addTask could fail for other reasons in a more complex app
                        taskView.showMessage("Failed to add task.");
                    }
                    break;

                case 2:
                    if (taskTracker.getTasks().isEmpty()) {
                        taskView.showMessage("No tasks to mark. Add a task first.");
                        break;
                    }
                    taskView.showMessage(taskView.getTaskIndexPrompt()); // Show prompt via view
                    int indexToMarkInput = -1;
                    if (scanner.hasNextInt()) {
                        indexToMarkInput = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        int actualIndex = indexToMarkInput - 1; // Adjust for 0-based indexing
                        Task taskToMark = taskTracker.getTask(actualIndex);

                        if (taskToMark != null) { // Check if task exists at index
                            if (taskToMark.isCompleted()){
                                taskView.showMessage("Task '" + taskToMark.getDescription() + "' is already completed.");
                            } else {
                                if (taskTracker.markTaskCompleted(actualIndex)) {
                                    taskView.showMessage("Task marked as completed: " + taskToMark.getDescription());
                                } else {
                                    // This path should ideally not be hit if getTask returned non-null
                                    // and markTaskCompleted only fails on bad index, which we checked.
                                    // Kept for robustness in case logic changes.
                                    taskView.showMessage("Failed to mark task as completed.");
                                }
                            }
                        } else {
                            taskView.showMessage("Invalid task index.");
                        }
                    } else {
                        taskView.showMessage("Invalid input for index. Please enter a number.");
                        if(scanner.hasNextLine()) scanner.nextLine(); // Consume invalid input
                    }
                    break;

                case 3:
                    taskView.displayTasks(taskTracker.getTasks());
                    break;

                case 4:
                    taskView.showMessage("Exiting the Task Tracker. Goodbye!");
                    scanner.close(); // Close scanner on exit
                    System.exit(0);
                    break; // Not strictly necessary after System.exit(0) but good practice

                default:
                    taskView.showMessage("Invalid choice. Please choose a valid option.");
            }
        }
    }
}