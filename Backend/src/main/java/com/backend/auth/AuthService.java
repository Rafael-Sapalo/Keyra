package com.backend.auth;

import com.backend.auth.dto.LoginRequest;
import com.backend.user.UserEntity;
import com.backend.user.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String login(LoginRequest loginRequest) {
        return loginRequest.getEmail();
    }

    @Override
    public String refresh() {
        return "TOKEN";
    }

    @Override
    public String logout() {
        return "TOKEN";
    }
}
