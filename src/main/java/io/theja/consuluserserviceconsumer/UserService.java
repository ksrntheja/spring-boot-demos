package io.theja.consuluserserviceconsumer;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

// TODO 4: Add service.
@Service
class UserService {

    private final RestTemplate restTemplate;

    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getUserMessage() {
        // TODO 5: Add URL.
        String url = "http://consul-user-service//users/hello";
        return restTemplate.getForObject(url, String.class);
    }

}
