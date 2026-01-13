package io.theja.cloudgatewayapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CloudGatewayApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudGatewayApiGatewayApplication.class, args);
    }

}

/*
TODO:
# Spring Cloud Config - Centralized configuration - Config Client?
 Local and Git
# Prometheus & Grafana

# Resilience (circuit breakers, retries)
 Rate limiting - Redis? || bucket4j is a Java rate-limiter library that can run entirely in memory || Use Resilience4j’s RateLimiter (Reactive)
# Observability (metrics, tracing, logs)
# API Versioning - Path-Based Versioning (v1 and v2 spring boot apps) & Header-Based Versioning
# Global Exception Handling
# Caching with Spring Cache (In-Memory) or Redis (Distributed)
# Ensure your resource server can start even if the auth server is down by tuning timeouts

# How Spring Cloud Gateway Validates Your JWT
 When you call -> curl -H "Authorization: Bearer eyJ…​" http://localhost:8080/sample
 Spring Security’s Resource Server support (enabled by spring-boot-starter-oauth2-resource-server) kicks in and performs these steps under the hood:
 1. Bearer Token Extraction: A preconfigured WebFilter (BearerTokenAuthenticationFilter) intercepts every HTTP request. It looks for an Authorization header starting with Bearer.
 2. Metadata Discovery & JWK Set Fetch: On startup, Spring Security reads your issuer-uri (e.g. http://localhost:8080/auth/realms/myrealm). It appends /.well-known/openid-configuration to fetch the OIDC (OpenID Connect) discovery document, which includes a jwks_uri. The jwks_uri points to a JSON Web Key Set (JWKS) endpoint. Spring pulls this set of public keys and caches them.
 3. Signature & Claim Verification: The JwtDecoder (backed by Nimbus JOSE) uses the cached JWKS to verify the JWT’s cryptographic signature. It also checks standard claims automatically: iss (issuer) matches your issuer-uri. && exp (expiration) and nbf (not before) are valid. &&  (Optionally) aud (audience) contains your resource server’s identifier, if you’ve configured it.
 Public-Key Cryptography Lets You Verify with Only the Public Side: When you sign JWTs using an asymmetric algorithm (e.g. RS256), the authorization server uses its private key to create the signature. The resource server needs only the matching public key to verify that signature—no private key required. No private key is needed at the Resource Server because public-key cryptography ensures only a private-key holder could have produced that signature.

TODO 4: Run the app.
curl --location 'http://localhost:8080/sample' \
--header 'Authorization: Bearer eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJleGFtcGxlLmlvIiwic3ViIjoiYWxpY2UiLCJleHAiOjE3NjgzMDEwODgsImlhdCI6MTc2ODI5NzQ4OCwicm9sZXMiOlsiUk9MRV9VU0VSIl19.BD0P1KiBacz4LwwxUxGHr0XpWfiB_joYxWjEEndVK8GQ-tA8ETJ9HQEECoIXx6joCWvhTOvi6KLyJ5zC6cGAJQ_DDcCvM--Y4BPhyS_4u0yL0UtGV4oQARfR6rrbF1ItVkLA0WnU8I-OdV6yUkwMpDIS9oZM-CKfWYwbH-icWgLPr3-k3U22ka3EEx0nq3cI78VJZSVC15IoB1cVAVfofFu1HrzjYtYqND0ovRxmobwEx6DP3EzeK6-X5xriwbWIy9D9a22JE-LelKd2OY2g36o1JhmOwTomezaGQf7iE5lEX8pl0DFMSdyCyPCqv95Fs5tipDj5JAjIlGPyGkTNOw'

 */
