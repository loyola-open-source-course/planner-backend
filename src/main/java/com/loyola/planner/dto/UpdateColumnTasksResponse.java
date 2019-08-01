package com.loyola.planner.dto;

import lombok.Data;

/**
 * @author Alexander Kohonovsky
 * @since 2019-08-01
 */
@Data
public class UpdateColumnTasksResponse {

    private boolean isSuccessful;

    public UpdateColumnTasksResponse(boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }

}
