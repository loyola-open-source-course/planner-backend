package com.loyola.planner.controllers;

import com.loyola.planner.controllers.models.LoginRequest;
import com.loyola.planner.controllers.models.LoginResponse;
import com.loyola.planner.controllers.models.SignupRequest;
import com.loyola.planner.controllers.models.SignupResponse;
import com.loyola.planner.entities.User;
import com.loyola.planner.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Alexander Kohonovsky
 * @since 2019-07-30
 */
@RequiredArgsConstructor
@RestController
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    @PostMapping("/api/auth/login")
    public LoginResponse login(@RequestBody @Valid LoginRequest request) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                request.username, request.password);
        Authentication authenticate = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        User user = userService.loadUserByUsername(request.username);
        return new LoginResponse(user);
    }

    @PostMapping("/api/auth/singup")
    public void signup(@RequestBody @Valid SignupRequest request) {
        userService.createUser(request);
    }

}
