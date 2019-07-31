package com.loyola.planner.controllers.models;

import com.loyola.planner.entities.Task;
import com.loyola.planner.entities.TaskStatus;
import lombok.Data;

import java.time.ZonedDateTime;

/**
 * @author Alexander Kohonovsky
 * @since 2019-07-31
 */
@Data
public class TaskModel {

    private Long id;
    private String description;
    private TaskStatus status;
    private ZonedDateTime createdAt;
    private Long authorId;

    public TaskModel(Task t) {
        this.id = t.getId();
        this.description = t.getDescription();
        this.status = t.getTaskStatus();
        this.createdAt = t.getCreatedAt();
        this.authorId = t.getAuthor().getId();
    }

}
