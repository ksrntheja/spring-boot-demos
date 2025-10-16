package io.theja.resiliencedemo;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

// TODO 3: Adding MyRestController
@RestController
@RequestMapping("/")
class MyRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyRestController.class);

    private static final AtomicInteger counter = new AtomicInteger(0);

    private final CircuitBreakerService circuitBreakerService;

    public MyRestController(
            CircuitBreakerService circuitBreakerService
    ) {
        this.circuitBreakerService = circuitBreakerService;
    }

    @GetMapping("/breaker")
    public ResponseEntity<?> getCircuitBreakerServiceDemo() {
        System.out.println(counter.incrementAndGet());
        return ResponseEntity.ok(circuitBreakerService.circuitBreakerServiceDemo());
    }

}

// TODO 4: http://localhost:8080/breaker
/*
show DATABASES;
create DATABASE serviceup;
-- Step 1: Create the user
CREATE USER 'new_user'@'localhost' IDENTIFIED BY 'strong_password';
-- Step 2: Grant privileges on the specific database
GRANT ALL PRIVILEGES ON serviceup.* TO 'new_user'@'localhost';
-- Step 3: Apply changes
FLUSH PRIVILEGES;

USE serviceup;
REVOKE ALTER, DROP, CREATE, INSERT ON serviceup.* FROM 'new_user'@'localhost';
FLUSH PRIVILEGES;
GRANT ALL PRIVILEGES ON serviceup.* TO 'new_user'@'localhost';
FLUSH PRIVILEGES;

Restart the other service
 */
