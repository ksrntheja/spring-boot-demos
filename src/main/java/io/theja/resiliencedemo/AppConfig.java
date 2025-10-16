package io.theja.resiliencedemo;

import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
class AppConfig {

    private static final int TIMEOUT_MILLIS = 5000;

    @Bean
    // TODO 1A: RestTemplate timeouts
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                // maximum time allowed for establishing an initial connection between the
                //  client and the remote server - TCP handshake
                .connectTimeout(Duration.ofMillis(TIMEOUT_MILLIS))
                // how long the client will wait for a response (i.e., data) from the server
                .readTimeout(Duration.ofMillis(TIMEOUT_MILLIS))
                .build();
    }

}
