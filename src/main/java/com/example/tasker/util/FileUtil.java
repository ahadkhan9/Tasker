package com.example.tasker.util;

import com.example.tasker.model.Task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static List<Task> loadTasks(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        List<Task> tasks = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String description = parts[1];
                String status = parts[2];
                String createdAt = parts[3];
                String updatedAt = parts[4];
                Task task = new Task(id, description);
                task.setStatus(status);
                task.setCreatedAt(createdAt);
                task.setUpdatedAt(updatedAt);
                tasks.add(task);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tasks;
    }

    public static void saveTasks(List<Task> tasks, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Task task : tasks) {
                writer.write(task.getId() + "," +
                        task.getDescription() + "," +
                        task.getStatus() + "," +
                        task.getCreatedAt() + "," +
                        task.getUpdatedAt() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
