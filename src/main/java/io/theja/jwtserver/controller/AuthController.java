package io.theja.jwtserver.controller;

import java.util.Set;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import io.theja.jwtserver.repository.UserRepository;
import io.theja.jwtserver.model.User;
import io.theja.jwtserver.service.JwtService;
import io.theja.jwtserver.dto.AuthResponse;
import io.theja.jwtserver.dto.LoginDto;
import io.theja.jwtserver.dto.RegisterDto;


// TODO 5:  Add auth controller.
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtService jwtService;
    private final UserRepository userRepo;
    private final PasswordEncoder encoder;

    public AuthController(AuthenticationManager authManager, JwtService jwtService, UserRepository userRepo, PasswordEncoder encoder) {
        this.authManager = authManager;
        this.jwtService = jwtService;
        this.userRepo = userRepo;
        this.encoder = encoder;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDto dto) {
        String encoded = encoder.encode(dto.getPassword());
        Set<String> roles = Set.of("ROLE_USER");
        User user = new User(dto.getUsername(), encoded, roles, true);
        userRepo.save(user);
        return ResponseEntity.ok("User registered");
    }


    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginDto dto) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword())
        );
        var user = userRepo.findByUsername(dto.getUsername()).orElseThrow();
        String token = jwtService.generateToken(user);
//        return ResponseEntity.ok(new AuthResponse(token));

        // Create the HttpOnly cookie
        ResponseCookie cookie = ResponseCookie.from("token", token)
                .httpOnly(true)       // Prevents JS access - Makes it invisible to document.cookie.
                .secure(true)         // Sends only over HTTPS.
                .sameSite("Strict")   // Protects against CSRF - Prevents CSRF attacks by not sending the cookie on cross-site requests.
                .path("/")            // Available for all routes.
                .maxAge(36)         // 1 hour expiry.
                .build();

        // Add the cookie to the response header
        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new AuthResponse("Logged in successfully"));

        // Set-Cookie: token=eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJleGFtcGxlLmlvIiwic3ViIjoiYWxpY2UiLCJleHAiOjE3Njk3MDM4NDksImlhdCI6MTc2OTcwMDI0OSwicm9sZXMiOlsiUk9MRV9VU0VSIl19.b9ES0l4piapGQA7z5R0doilXc1K5Sh9OCDSbfYKXc9byqgnS9gDCZNTsGUYIqlGN9cDHOEgege6ylpAwLjULluGSCFgKnFCO3YHaaW4W_g0yOtrJykk7dQN9B0VeZNLx3AKcHALOogmD5yBf6DCP7LYQKpYxAvlpCR4a8m7qJ7iayh0fktKoYZjixqp9YFL7RmX56xWKWNUf-q5DkZ65GugIXQDlOnvlgL-qwRqpjj4u34zzZdq1XpMONEGHy1mCljuJmIXsVCuaKqfUzhTEWDQ9vN1whS31d16GLB0bdwAqFEhZ1Nb3tGTBUOEatvtkZBvV_SOl7g01AaJqstS-1A; Path=/; Max-Age=3600; Expires=Thu, 29 Jan 2026 16:24:09 GMT; Secure; HttpOnly; SameSite=Strict
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        ResponseCookie cookie = ResponseCookie.from("token", "")
                .httpOnly(true)
                .secure(true)
                .path("/")
                .maxAge(0) // Expire immediately
                .build();
        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body("Logged out");
    }

}
