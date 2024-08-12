package com.example.tasker.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private int id;
    private String description;
    private String status;
    private String createdAt;
    private String updatedAt;

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        this.status = "todo";
        this.createdAt = getCurrentTime();
        this.updatedAt = this.createdAt;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    // Update method
    public void update(String description, String status) {
        this.description = description;
        this.status = status;
        this.updatedAt = getCurrentTime();
    }

    // Current time formatter
    private String getCurrentTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @Override
    public String toString() {
        return "Task [id=" + id + ", description=" + description + ", status=" + status +
                ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
    }
}
