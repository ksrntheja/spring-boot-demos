package io.theja.distributed_tracing_service_two_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

// TODO 4: Add controller.
@RestController
public class ServiceTwoRestController {

    private final static Logger LOGGER = Logger.getLogger(ServiceTwoRestController.class.getName());

    private final RestTemplate restTemplate;


    public ServiceTwoRestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

//    @GetMapping() // Headers are removed much earlier.
//    public String result(
//            @RequestHeader(required = false) HttpHeaders httpHeaders
//    ) {
//        LOGGER.info("Request received for service two!");
//        if (httpHeaders != null) {
//            LOGGER.info(httpHeaders.toString());
//        }
//        return "Working!";
//    }


    @GetMapping()
    public String result() {
        LOGGER.info("Request received for service two!");
        return restTemplate.getForObject("http://localhost:8082", String.class);
    }

}
