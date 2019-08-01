package com.loyola.planner.services;

import com.loyola.planner.dto.SignupRequest;
import com.loyola.planner.entities.User;
import com.loyola.planner.exceptions.UserAlreadyExist;
import com.loyola.planner.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Alexander Kohonovsky
 * @since 2019-07-30
 */
@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return usersRepository.findByUsername(username);
    }

    public void createUser(SignupRequest request) {
        User foundUser = usersRepository.findByUsername(request.getUsername());
        if (foundUser != null) {
            throw new UserAlreadyExist();
        }

        User user = new User();
        user.setFullName(request.getFullName());
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        usersRepository.save(user);
    }

}
