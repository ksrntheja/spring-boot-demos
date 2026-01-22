package io.theja.distributed_tracing_service_one_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

// TODO 4: Add controller.
@RestController
public class ServiceOneRestController {

    private final static Logger LOGGER = Logger.getLogger(ServiceOneRestController.class.getName());

    private final RestTemplate restTemplate;


    public ServiceOneRestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String result() {
        LOGGER.info("Request received for service one!");
//        return "Working!";
        return restTemplate.getForObject("http://localhost:8081", String.class);
    }

}
