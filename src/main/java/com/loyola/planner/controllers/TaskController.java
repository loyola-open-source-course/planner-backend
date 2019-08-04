package com.loyola.planner.controllers;

import com.loyola.planner.dto.NewTaskRequest;
import com.loyola.planner.dto.TaskModel;
import com.loyola.planner.entities.User;
import com.loyola.planner.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Alexander Kohonovsky
 * @since 2019-07-03
 */
@PreAuthorize("isAuthenticated()")
@RequiredArgsConstructor
@RestController
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/api/v1/tasks")
    public List<TaskModel> getTasks() {
        return taskService.getTasks();
    }

    @PostMapping("/api/v1/tasks")
    public TaskModel getTasks(@RequestBody NewTaskRequest task,
                              @AuthenticationPrincipal User currentUser) {
        return taskService.createTask(task, currentUser);
    }

    @PutMapping("/api/v1/tasks/{taskId}")
    public TaskModel getTasks(@PathVariable Long taskId,
                              @RequestBody NewTaskRequest task,
                              @AuthenticationPrincipal User currentUser) {
        return taskService.updateTask(taskId, task, currentUser);
    }

    @DeleteMapping("/api/v1/tasks/{taskId}")
    public void getTasks(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
    }

}
