package com.backend.auth;

import com.backend.auth.dto.LoginRequest;
import com.backend.auth.dto.LoginResponse;

public interface IAuthService {
    LoginResponse login(LoginRequest loginRequest);
    String refresh();
    String logout();
}
