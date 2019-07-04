package com.loyola.planner.repositories;

import com.loyola.planner.models.Task;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alexander Kohonovsky
 * @since 2019-07-03
 */
@Repository
public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {

}
