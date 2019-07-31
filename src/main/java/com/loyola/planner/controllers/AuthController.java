package com.loyola.planner.controllers;

import com.loyola.planner.controllers.models.LoginRequest;
import com.loyola.planner.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alexander Kohonovsky
 * @since 2019-07-30
 */
@RequiredArgsConstructor
@RestController
public class AuthController {

    private final AuthenticationManager authenticationManager;

    @PostMapping("/auth/login")
    public void login(LoginRequest request) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                request.username, request.password);
        Authentication authenticate = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authenticate);
    }

    @PostMapping("/auth/singup")
    public void signup() {

    }

}
