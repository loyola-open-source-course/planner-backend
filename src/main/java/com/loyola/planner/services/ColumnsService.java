package com.loyola.planner.services;

import com.loyola.planner.dto.ColumnModel;
import com.loyola.planner.dto.UpdateColumnTasksRequest;
import com.loyola.planner.dto.UpdateColumnTasksResponse;
import com.loyola.planner.entities.Column;
import com.loyola.planner.exceptions.NotFoundException;
import com.loyola.planner.repositories.ColumnRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alexander Kohonovsky
 * @since 2019-08-01
 */
@RequiredArgsConstructor
@Service
public class ColumnsService {

    private final ColumnRepository columnRepository;

    public List<ColumnModel> getColumns() {
        return columnRepository.findAll().stream().map(ColumnModel::new).collect(Collectors.toList());
    }

    public UpdateColumnTasksResponse updateTasks(UpdateColumnTasksRequest request) {
        UpdateColumnTasksResponse response = new UpdateColumnTasksResponse(true);
        try {
            Column column = columnRepository.findById(request.getColumnId()).orElseThrow(NotFoundException::new);
            column.setTaskIds(request.getTaskIds());
            columnRepository.save(column);
        } catch (Exception e) {
            response.setSuccessful(false);
        }
        return response;
    }

}
