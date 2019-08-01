package com.loyola.planner.services;

import com.loyola.planner.dto.NewTaskRequest;
import com.loyola.planner.dto.TaskModel;
import com.loyola.planner.entities.Task;
import com.loyola.planner.entities.User;
import com.loyola.planner.repositories.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alexander Kohonovsky
 * @since 2019-07-31
 */
@RequiredArgsConstructor
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public List<TaskModel> getTasks() {
        return taskRepository.findAll().stream().map(TaskModel::new).collect(Collectors.toList());
    }

    public TaskModel createTask(NewTaskRequest request, User currentUser) {
        Task newTask = new Task();
        newTask.setDescription(request.getDescription());
        newTask.setAuthor(currentUser);
        newTask.setCreatedAt(ZonedDateTime.now());
        Task savedTask = taskRepository.save(newTask);
        return new TaskModel(savedTask);
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

}
