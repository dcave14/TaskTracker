// Dakota Cave
// Java II
// 2/6/24

package model;

import java.util.ArrayList;
import java.util.List;

/**
 * The TaskManager class represents a manager for tasks.
 * It provides methods to add tasks, complete tasks, and retrieve tasks.
 */
public class TaskManager {
    private final List<Task> tasks = new ArrayList<>();
    private static int idCounter = 0;

    /**
     * Adds a new task with the given description to the task manager.
     *
     * @param description the description of the task
     */
    public void addTask(String description) {
        Task newTask = new Task(++idCounter, description);
        tasks.add(newTask);
    }

    /**
     * Marks a task with the given ID as completed.
     *
     * @param id the ID of the task to be completed
     */
    public void completeTask(int id) {
        tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst()
                .ifPresent(task -> task.setCompleted(true));
    }

    /**
     * Returns the list of tasks managed by the task manager.
     *
     * @return the list of tasks
     */
    public List<Task> getTasks() {
        return tasks;
    }
}
