package com.loyola.planner.controllers;

import com.loyola.planner.entities.Task;
import com.loyola.planner.entities.TaskStatus;
import com.loyola.planner.repositories.TaskRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alexander Kohonovsky
 * @since 2019-07-03
 */
@RestController
public class MainController {

    private final TaskRepository taskRepository;

    public MainController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/api/hello-world")
    public String helloWorld() {
        return "Hello world";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/api/secured-hello-world")
    public String securedHelloWorld() {
        return "Authenticated Hello world";
    }

    @GetMapping("/api/insert-sample-task")
    public Task insertSampleTask() {
        Task task = new Task();
        task.setDescription("Hello world!");
        task.setTaskStatus(TaskStatus.TODO);
        task = taskRepository.save(task);
        return task;
    }

    @GetMapping("/api/tasks")
    public Iterable<Task> getTasks() {
        return taskRepository.findAll();
    }

    @PostMapping("/api/tasks")
    public void getTasks(@RequestBody Task task) {
        taskRepository.save(task);
    }

}
