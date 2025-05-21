package com.auth;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthService {

    public String login(String username, String password) {}
    public String logout() {}
    public String refreshToken(String token) {}
}
