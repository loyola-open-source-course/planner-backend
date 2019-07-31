package com.loyola.planner.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Alexander Kohonovsky
 * @since 2019-07-31
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Such user already exist.")
public class UserAlreadyExist extends RuntimeException {
}
