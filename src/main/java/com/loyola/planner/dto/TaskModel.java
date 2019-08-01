package com.loyola.planner.dto;

import com.loyola.planner.entities.Task;
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
    private ZonedDateTime createdAt;
    private Long authorId;
    private String authorName;

    public TaskModel(Task t) {
        this.id = t.getId();
        this.description = t.getDescription();
        this.createdAt = t.getCreatedAt();
        this.authorId = t.getAuthor().getId();
        this.authorName = t.getAuthor().getFullName();
    }

}
