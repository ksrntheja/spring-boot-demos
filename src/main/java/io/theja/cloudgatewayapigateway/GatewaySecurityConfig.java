package io.theja.cloudgatewayapigateway;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.NimbusReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.util.StreamUtils;

// TODO 3: Add security config.
@Configuration
@EnableWebFluxSecurity
// Without this config - all requests gets redirected to /login.
// Spring Boot’s security auto-configuration sees that you’ve pulled in Spring Security (directly or via spring-boot-starter-oauth2-resource-server) and, by default, enables form-based login.
public class GatewaySecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http
                // 1) disable CSRF; Gateway is stateless
                .csrf(ServerHttpSecurity.CsrfSpec::disable)

                // 2) disable form login & basic auth
                .httpBasic(ServerHttpSecurity.HttpBasicSpec::disable)
                .formLogin(ServerHttpSecurity.FormLoginSpec::disable)

                // 3) require authentication for everything
                .authorizeExchange(exchanges -> exchanges
                        .anyExchange().authenticated()
                )

                // 4) use JWT tokens
                .oauth2ResourceServer(ServerHttpSecurity.OAuth2ResourceServerSpec::jwt);

        return http.build();
    }

    public RSAPublicKey loadPublicKey() throws Exception {
        String publicKeyPEM;
        try (InputStream is = new ClassPathResource("keys/jwt-public.pem").getInputStream()) {
            publicKeyPEM = StreamUtils.copyToString(is, StandardCharsets.UTF_8)
                    .replaceAll("-----BEGIN (.*)-----", "")
                    .replaceAll("-----END (.*)-----", "")
                    .replaceAll("\\s", "");
        }
        byte[] decoded = Base64.getDecoder().decode(publicKeyPEM);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(decoded);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return (RSAPublicKey) kf.generatePublic(spec);
    }

    @Bean
    public ReactiveJwtDecoder jwtDecoder() throws Exception {
        RSAPublicKey publicKey = loadPublicKey(); // Load your RSA public key here
        return NimbusReactiveJwtDecoder.withPublicKey(publicKey).build();
    }


}
