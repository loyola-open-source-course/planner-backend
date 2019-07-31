package com.loyola.planner.controllers.models;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author Alexander Kohonovsky
 * @since 2019-07-30
 */
@Data
public class SignupRequest {

    @NotNull
    private String fullName;

    @NotNull
    private String username;

    @NotNull
    private String password;

}
