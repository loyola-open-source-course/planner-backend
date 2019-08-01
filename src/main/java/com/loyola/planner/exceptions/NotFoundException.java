package com.loyola.planner.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Alexander Kohonovsky
 * @since 2019-08-01
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Element not found.")
public class NotFoundException extends RuntimeException {

}
