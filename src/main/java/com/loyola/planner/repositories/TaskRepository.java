package com.loyola.planner.repositories;

import com.loyola.planner.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alexander Kohonovsky
 * @since 2019-07-03
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
