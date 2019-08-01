package com.loyola.planner.repositories;

import com.loyola.planner.entities.Column;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Alexander Kohonovsky
 * @since 2019-08-01
 */
public interface ColumnRepository extends JpaRepository<Column, Long> {

}
