package io.theja.consuluserservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

// TODO 3: Add controller.
@RestController
@RequestMapping("/")
@RefreshScope
class UserController {

    @Value("${server.port}")
    private String port;

    @Value("${foo}")
    private String foo;

    @GetMapping("/users/hello")
    public String hello() {
        return "Hello World " + foo + " from User Service " + port + ".";
    }


}
