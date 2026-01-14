package io.theja.springprofiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

// TODO 7: Add prod only config.
@Configuration
@Profile("prod")
public class ProdOnlyConfig {

    @Bean
    public String productionBean() {
        return "This bean only exists in PROD";
    }

}
