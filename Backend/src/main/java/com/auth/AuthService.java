package com.auth;

import com.jwt.JwtService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AuthService {
    JwtService jwtService;

    @Inject
    public AuthService(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    public String login(String email, String password) {
        String token = this.jwtService.generateToken(email);
        return "Welcome " + token + "!";
    }
    public String logout() {
        return "Goodbye!";
    }
    public String refreshToken(String token) {
        return "Refreshed token: " + token;
    }
}
