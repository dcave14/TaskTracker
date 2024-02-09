/* Dakota Cave
Java II
2/6/24 */

package model;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private final List<Task> tasks = new ArrayList<>();
    private static int idCounter = 0;

    public void addTask(String description) {
        Task newTask = new Task(++idCounter, description);
        tasks.add(newTask);
    }

    public void completeTask(int id) {
        tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst()
                .ifPresent(task -> task.setCompleted(true));
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
