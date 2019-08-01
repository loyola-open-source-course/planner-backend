package com.loyola.planner.dto;

import com.loyola.planner.entities.User;

/**
 * @author Alexander Kohonovsky
 * @since 2019-07-30
 */
public class LoginResponse {

    public String fullName;
    public String username;

    public LoginResponse(User user) {
        this.fullName = user.getFullName();
        this.username = user.getUsername();
    }

}
