package com.auth;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthService {

    public String login(String username, String password) {
        return "Welcome " + username + "!";
    }
    public String logout() {
        return "Goodbye!";
    }
    public String refreshToken(String token) {
        return "Refreshed token: " + token;
    }
}
