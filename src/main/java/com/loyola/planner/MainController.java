package com.loyola.planner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alexander Kohonovsky
 * @since 2019-07-03
 */
@RestController
public class MainController {

    @GetMapping("/api/hello-world")
    public String helloWorld() {
        return "Hello world";
    }

}
