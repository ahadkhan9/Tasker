package com.example.tasker.service;

import com.example.tasker.model.Task;
import com.example.tasker.util.FileUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private List<Task> tasks;
    private static final String FILE_PATH = "tasks.json";

    public TaskService() {
        tasks = FileUtil.loadTasks(FILE_PATH);
    }

    public void addTask(String description) {
        int id = tasks.size() + 1;
        Task task = new Task(id, description);
        tasks.add(task);
        FileUtil.saveTasks(tasks, FILE_PATH);
        System.out.println("Task added successfully (ID: " + id + ")");
    }

    public void updateTask(int id, String description) {
        Task task = findTaskById(id);
        if (task != null) {
            task.update(description, task.getStatus());
            FileUtil.saveTasks(tasks, FILE_PATH);
            System.out.println("Task updated successfully (ID: " + id + ")");
        } else {
            System.out.println("Task not found (ID: " + id + ")");
        }
    }

    public void deleteTask(int id) {
        Task task = findTaskById(id);
        if (task != null) {
            tasks.remove(task);
            FileUtil.saveTasks(tasks, FILE_PATH);
            System.out.println("Task deleted successfully (ID: " + id + ")");
        } else {
            System.out.println("Task not found (ID: " + id + ")");
        }
    }

    public void markTaskAsInProgress(int id) {
        Task task = findTaskById(id);
        if (task != null) {
            task.update(task.getDescription(), "in-progress");
            FileUtil.saveTasks(tasks, FILE_PATH);
            System.out.println("Task marked as in-progress (ID: " + id + ")");
        } else {
            System.out.println("Task not found (ID: " + id + ")");
        }
    }

    public void markTaskAsDone(int id) {
        Task task = findTaskById(id);
        if (task != null) {
            task.update(task.getDescription(), "done");
            FileUtil.saveTasks(tasks, FILE_PATH);
            System.out.println("Task marked as done (ID: " + id + ")");
        } else {
            System.out.println("Task not found (ID: " + id + ")");
        }
    }

    public void listTasks(String statusFilter) {
        tasks.stream()
                .filter(task -> statusFilter == null || task.getStatus().equalsIgnoreCase(statusFilter))
                .forEach(System.out::println);
    }

    private Task findTaskById(int id) {
        return tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
