package com.backend.auth;

import com.backend.auth.dto.LoginRequest;

public interface IAuthService {
    String login(LoginRequest loginRequest);
    String refresh();
    String logout();
}
