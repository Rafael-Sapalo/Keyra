package com.backend.auth;

import com.backend.auth.dto.LoginRequest;
import com.backend.auth.dto.LoginResponse;
import com.backend.exception.ResourceNotFoundException;
import com.backend.jwt.JwtService;
import com.backend.user.entity.UserEntity;
import com.backend.user.repository.UserRepository;
import jakarta.inject.Inject;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AuthService implements IAuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    @Inject
    public AuthService(UserRepository userRepository,  JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Optional<UserEntity> userData = Optional.ofNullable(this.userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("User with this email:" + loginRequest.getEmail() + "does not exist")));
        if (userData.isEmpty()) {
            throw new AuthServiceException("User not found");
        }
        return new LoginResponse(this.jwtService.generateToken(String.valueOf(userData.get().getId()), userData.get().getEmail()));
    }

    @Override
    public String refresh() {
        return this.jwtService.generateToken("azertyui", "txycuvbiun");
    }

    @Override
    public String logout() {
        return "TOKEN";
    }
}
