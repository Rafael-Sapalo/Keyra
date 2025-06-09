package com.backend.auth;

import com.backend.auth.dto.LoginRequest;
import com.backend.auth.dto.LoginResponse;
import com.backend.user.UserEntity;
import com.backend.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService implements IAuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) throws RuntimeException {
        try {
            Optional<UserEntity> userData = this.userRepository.findByEmail(loginRequest.getEmail());
            if (userData.isEmpty()) {
                throw new AuthServiceException("User not found");
            }
            return new LoginResponse(userData.get().getPassword());
        } catch (RuntimeException e) {
            throw new AuthServiceException(e.getMessage());
        }
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
