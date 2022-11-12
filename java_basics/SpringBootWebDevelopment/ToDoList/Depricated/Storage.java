package main;

import main.model.Task;

import java.time.LocalDateTime;
import java.util.*;

public class Storage {
    private static int currentId = 1;
    private static Map<Integer, Task> tasks = new HashMap<>();

    public static List<Task> getAllTasks() {
        ArrayList<Task> taskList = new ArrayList<Task>(tasks.values());
        return taskList;
    }

    public static int addTask(Task task) {
        int id = currentId++;
        task.setId(id);
        task.setCreationDate(LocalDateTime.now());
        tasks.put(id, task);
        return id;
    }

    public static Task getTask(int taskId) {
        if (tasks.containsKey(taskId)) {
            return tasks.get(taskId);
        }
        return null;
    }

    public static void deleteAllTasks() {
        tasks.clear();
    }

    public static Task deleteTask(String taskId) {
        int id = Integer.parseInt(taskId);
        if (tasks.containsKey(id)) {
            return  tasks.remove(id);
        }
        return null;
    }

    public static int putTask(int taskId, Task task) {
        if (tasks.containsKey(taskId)) {
            tasks.put(taskId, task);
            return 0;
        }
        return addTask(task);
    }
}
