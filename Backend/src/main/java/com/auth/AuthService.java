package com.auth;

import com.jwt.JwtService;
import com.user.UserEntity;
import com.user.UserRepository;
import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AuthService {
    private final JwtService jwtService;
    private final UserRepository userRepository;

    @Inject
    public AuthService(JwtService jwtService, UserRepository userRepository) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }

    public String login(String email, String password) {
        UserEntity user = this.userRepository.findByEmail(email);
        if (user == null) {
            return null;
        }
        if (!BcryptUtil.matches(password, user.getPassword())) {
            return null;
        }
        return this.jwtService.generateToken(email);
    }
    public String logout() {
        return "Goodbye!";
    }
    public String refreshToken(String token) {
        return "Refreshed token: " + token;
    }
}
