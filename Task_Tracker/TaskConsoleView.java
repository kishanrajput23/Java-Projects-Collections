package Task_Tracker;
import java.util.List;

public class TaskConsoleView {

    // Responsibility: Display the list of tasks.
    public void displayTasks(List<Task> tasks) {
        System.out.println("\nTask List:");
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            // Using getDescription() and isCompleted() from Task object
            System.out.println((i + 1) + ". " + task.getDescription() +
                    (task.isCompleted() ? " - Completed" : ""));
        }
    }

    // Responsibility: Display the application menu.
    public void displayMenu() {
        System.out.println("\n1. Add Task\n2. Mark Task as Completed\n3. Display Tasks\n4. Exit");
        System.out.print("Choose an option: ");
    }

    // Responsibility: Display a generic message.
    public void showMessage(String message) {
        System.out.println(message);
    }

    // Responsibility: Return the prompt string for task description.
    public String getTaskDescriptionPrompt() {
        return "Enter task description: ";
    }

    // Responsibility: Return the prompt string for task index.
    public String getTaskIndexPrompt() {
        return "Enter the index of the task to mark as completed: ";
    }
}