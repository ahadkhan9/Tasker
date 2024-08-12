package com.example.tasker.controller;

import com.example.tasker.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class TaskController implements CommandLineRunner {

    @Autowired
    private TaskService taskService;

    @Override
    public void run(String... args) {
        if (args.length == 0) {
            System.out.println("Usage: task-cli [add|update|delete|mark-in-progress|mark-done|list] [arguments...]");
            return;
        }

        String command = args[0];

        switch (command) {
            case "add":
                if (args.length > 1) {


                    taskService.addTask(args[1]);
                } else {
                    System.out.println("Usage: task-cli add \"Task description\"");
                }
                break;
            case "update":
                if (args.length > 2) {
                    taskService.updateTask(Integer.parseInt(args[1]), args[2]);
                } else {
                    System.out.println("Usage: task-cli update [id] \"Updated description\"");
                }
                break;
            case "delete":
                if (args.length > 1) {
                    taskService.deleteTask(Integer.parseInt(args[1]));
                } else {
                    System.out.println("Usage: task-cli delete [id]");
                }
                break;
            case "mark-in-progress":
                if (args.length > 1) {
                    taskService.markTaskAsInProgress(Integer.parseInt(args[1]));
                } else {
                    System.out.println("Usage: task-cli mark-in-progress [id]");
                }
                break;
            case "mark-done":
                if (args.length > 1) {
                    taskService.markTaskAsDone(Integer.parseInt(args[1]));
                } else {
                    System.out.println("Usage: task-cli mark-done [id]");
                }
                break;
            case "list":
                if (args.length > 1) {
                    taskService.listTasks(args[1]);
                } else {
                    taskService.listTasks(null);
                }
                break;
            default:
                System.out.println("Unknown command: " + command);
                break;
        }
    }
}
