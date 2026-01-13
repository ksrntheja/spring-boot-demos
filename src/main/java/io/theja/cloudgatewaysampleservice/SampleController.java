package io.theja.cloudgatewaysampleservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// TODO 3: Add controller.
@RestController
@RequestMapping("/sample")
public class SampleController {

    @Value("${foo}")
    private String foo;

    @GetMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello from Sample Service - " + foo + ".");
    }

}
