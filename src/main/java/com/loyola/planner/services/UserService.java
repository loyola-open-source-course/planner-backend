package com.loyola.planner.services;

import com.loyola.planner.controllers.models.SignupRequest;
import com.loyola.planner.entities.User;
import com.loyola.planner.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

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
        User user = new User();
        user.setFullName(request.fullName);
        user.setUsername(request.username);
        user.setPassword(passwordEncoder.encode(request.password));
        usersRepository.save(user);
    }

}
