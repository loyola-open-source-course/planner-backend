package com.loyola.planner.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author Alexander Kohonovsky
 * @since 2019-08-01
 */
@Data
public class UpdateColumnTasksRequest {

    @NotNull
    private Long columnId;

    @NotNull
    private String taskIds;

}
