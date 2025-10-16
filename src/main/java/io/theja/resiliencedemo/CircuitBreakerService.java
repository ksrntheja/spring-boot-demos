package io.theja.resiliencedemo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

// TODO 2: Adding CircuitBreakerService
@Service
public class CircuitBreakerService {

    private static final Logger LOGGER = Logger.getLogger(CircuitBreakerService.class.getName());

    private final RestTemplate restTemplate;

    public CircuitBreakerService(
            RestTemplate restTemplate
    ) {
        this.restTemplate = restTemplate;
    }

    @CircuitBreaker(
            name = "demoBreaker",
            fallbackMethod = "fallbackCircuitBreakerServiceDemo"
    )
    public String circuitBreakerServiceDemo() {
        return restTemplate.postForObject("http://localhost:8081/api/records/auto", "", String.class);
    }

    public String fallbackCircuitBreakerServiceDemo(
            Throwable throwable
    ) {
        return "fallbackMethod(_)";
    }

}
