package com.loyola.planner.controllers;

import com.loyola.planner.controllers.models.NewTaskRequest;
import com.loyola.planner.entities.Task;
import com.loyola.planner.entities.User;
import com.loyola.planner.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alexander Kohonovsky
 * @since 2019-07-03
 */
@PreAuthorize("isAuthenticated()")
@RequiredArgsConstructor
@RestController
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/api/tasks")
    public Iterable<Task> getTasks() {
        return taskService.getTasks();
    }

    @PostMapping("/api/tasks")
    public void getTasks(@RequestBody NewTaskRequest task,
                         @AuthenticationPrincipal User currentUser) {
        taskService.createTask(task, currentUser);
    }

}
