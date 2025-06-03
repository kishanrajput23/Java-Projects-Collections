package Task_Tracker;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class TaskTracker {
    private ArrayList<Task> tasks;

    public TaskTracker() {
        tasks = new ArrayList<>();
    }

    // Responsibility: Add a task to the list.
    // Returns true if added successfully.
    public boolean addTask(String description) {
        Task newTask = new Task(description);
        tasks.add(newTask);
        return true;
    }

    // Responsibility: Mark a task as completed.
    // Returns true if task was found and marked, false otherwise.
    public boolean markTaskCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.markCompleted();
            return true;
        }
        return false;
    }

    // Responsibility: Provide access to the list of tasks.
    // Returns an unmodifiable list to prevent external modification.
    public List<Task> getTasks() {
        return Collections.unmodifiableList(tasks); // Return a read-only view
    }

    // Responsibility: Get a specific task by index.
    // Returns the Task object or null if index is invalid.
    public Task getTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            return tasks.get(index);
        }
        return null;
    }
}