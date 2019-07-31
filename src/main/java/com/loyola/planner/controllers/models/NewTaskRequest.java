package com.loyola.planner.controllers.models;

import com.loyola.planner.entities.TaskStatus;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

/**
 * @author Alexander Kohonovsky
 * @since 2019-07-31
 */
@Data
public class NewTaskRequest {

    @NotNull
    private String description;

    @NotNull
    private TaskStatus taskStatus;

}
