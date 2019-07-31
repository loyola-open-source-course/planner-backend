package com.loyola.planner.controllers.models;

import javax.validation.constraints.NotNull;

/**
 * @author Alexander Kohonovsky
 * @since 2019-07-30
 */
public class LoginRequest {

    @NotNull
    public String username;

    @NotNull
    public String password;

}
