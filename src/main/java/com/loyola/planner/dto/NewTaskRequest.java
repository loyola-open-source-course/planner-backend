package com.loyola.planner.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author Alexander Kohonovsky
 * @since 2019-07-31
 */
@Data
public class NewTaskRequest {

    @NotNull
    private String description;

}
