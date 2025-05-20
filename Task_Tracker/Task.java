package Task_Tracker;
import java.util.ArrayList;
import java.util.Scanner;

public class Task {
    private String description;
    private boolean completed;

    public Task(String description) {
        this.description = description;
        this.completed = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        completed = true;
    }

    // For easier debugging or direct object printing if needed elsewhere
    @Override
    public String toString() {
        return description + (completed ? " - Completed" : "");
    }
}