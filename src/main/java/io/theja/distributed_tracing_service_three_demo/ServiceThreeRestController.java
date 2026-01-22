package io.theja.distributed_tracing_service_three_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

// TODO 3: Add controller.
@RestController
public class ServiceThreeRestController {

    private final static Logger LOGGER = Logger.getLogger(ServiceThreeRestController.class.getName());

    @GetMapping()
    public String result() {
        LOGGER.info("Request received for service three!");
        return "Working!";
    }

}
