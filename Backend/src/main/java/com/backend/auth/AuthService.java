package com.backend.auth;

import com.backend.auth.dto.LoginRequest;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {

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
