package io.theja.jwtserver.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;

// TODO 16: Add actuator security config.
@Configuration
public class ActuatorSecurityConfig {

    @Bean
    @Order(1)
    public SecurityFilterChain actuatorHealthChain(HttpSecurity http) throws Exception {
        OrRequestMatcher healthOrInfoMatcher = new OrRequestMatcher(
                new AntPathRequestMatcher("/actuator/health"),
                new AntPathRequestMatcher("/actuator/info")
//                ,new AntPathRequestMatcher("/h2-console") TODO
        );

        http
                .securityMatcher(healthOrInfoMatcher)        // only these two paths
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()                // allow unauthenticated
                )
                .sessionManagement(sm ->
                        sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(csrf -> csrf.disable());

        return http.build();
    }

}
