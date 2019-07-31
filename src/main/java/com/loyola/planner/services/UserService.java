package com.loyola.planner.services;

import com.loyola.planner.entities.User;
import com.loyola.planner.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Alexander Kohonovsky
 * @since 2019-07-30
 */
@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UsersRepository usersRepository;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return usersRepository.findByUsername(username);
    }

}
