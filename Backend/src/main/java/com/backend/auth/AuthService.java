package com.backend.auth;

import com.backend.auth.dto.LoginRequest;
import com.backend.auth.dto.LoginResponse;
import com.backend.exception.ResourceNotFoundException;
import com.backend.jwt.JwtService;
import com.backend.user.entity.UserEntity;
import com.backend.user.repository.UserRepository;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class AuthService implements IAuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);

    @Inject
    public AuthService(UserRepository userRepository,  JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        logger.info("Login Request: email={} timestamp={}", email, System.currentTimeMillis());
        try {
            UserEntity user = this.userRepository.findByEmail(email)
                    .orElseThrow(() -> new ResourceNotFoundException("User dont exists"));
            String token = this.jwtService.generateToken(String.valueOf(user.getId()), user.getEmail());
            logger.info("Token generated: {}", token);
            return new LoginResponse(token);
        } catch (ResourceNotFoundException ex) {
            logger.warn("Login Request: email={}, error is: {}", email, ex.getMessage());
            throw ex;
        } catch (Exception ex) {
            logger.warn("Internal error Login Request: email={}, error is: {}", email, ex.getMessage());
            throw new AuthServiceException("Login failed due to internal error");
        }
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
