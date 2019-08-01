package com.loyola.planner.controllers;

import com.loyola.planner.dto.ColumnModel;
import com.loyola.planner.dto.UpdateColumnTasksRequest;
import com.loyola.planner.dto.UpdateColumnTasksResponse;
import com.loyola.planner.services.ColumnsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Alexander Kohonovsky
 * @since 2019-08-01
 */
@PreAuthorize("isAuthenticated()")
@RequiredArgsConstructor
@RestController
public class ColumnsController {

    private final ColumnsService columnsService;

    @GetMapping("/api/v1/columns")
    public List<ColumnModel> getColumns() {
        return columnsService.getColumns();
    }

    @PutMapping("/api/v1/columns")
    public UpdateColumnTasksResponse updateColumnTasks(@RequestBody @Validated UpdateColumnTasksRequest request) {
        return columnsService.updateTasks(request);
    }

}
