package io.theja.springprofiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

// TODO 6: Add service.
@Service
public class GreetingService {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${common.property}")
    private String commonProperty;

    public String greet() {
        return commonProperty + " from " + applicationName;
    }

}
