package io.theja.consuluserserviceconsumer;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// TODO 6: Add REST config.
@Configuration
class RestConfig {

    @Bean
    @LoadBalanced
    // TODO 7: Add @LoadBalanced.
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
