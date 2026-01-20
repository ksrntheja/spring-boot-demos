package io.theja.consuluserserviceconsumer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

// TODO 3: Add controller.
@RestController
@RequestMapping("/")
class ConsumerRestController {

    private final UserService userService;

    public ConsumerRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String consume() {
        return userService.getUserMessage();
    }

}
