package com.loyola.planner.repositories;

import com.loyola.planner.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alexander Kohonovsky
 * @since 2019-07-30
 */
@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
