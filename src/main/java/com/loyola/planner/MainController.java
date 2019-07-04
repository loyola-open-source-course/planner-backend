package com.loyola.planner;

import com.loyola.planner.models.Task;
import com.loyola.planner.models.TaskStatus;
import com.loyola.planner.repositories.TaskRepository;
import org.springframework.web.bind.annotation.GetMapping;
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

}
