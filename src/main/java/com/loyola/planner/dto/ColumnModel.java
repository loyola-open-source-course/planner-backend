package com.loyola.planner.dto;

import com.loyola.planner.entities.Column;
import lombok.Data;

/**
 * @author Alexander Kohonovsky
 * @since 2019-08-01
 */
@Data
public class ColumnModel {

    private Long id;
    private String title;
    private String taskIds;

    public ColumnModel(Column column) {
        this.id = column.getId();
        this.title = column.getTitle();
        this.taskIds = column.getTaskIds();
    }

}
