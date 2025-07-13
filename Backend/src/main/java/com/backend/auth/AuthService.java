package com.backend.auth;

import com.backend.auth.dto.LoginRequest;
import com.backend.auth.dto.LoginResponse;
import com.backend.auth.metrics.AuthMetrics;
import com.backend.exception.ResourceNotFoundException;
import com.backend.jwt.JwtService;
import com.backend.jwt.TokenEntity;
import com.backend.jwt.TokenRepository;
import com.backend.user.entity.UserEntity;
import com.backend.user.repository.UserRepository;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Instant;


@Service
public class AuthService implements IAuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final TokenRepository tokenRepository;
    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);
    private final AuthMetrics authMetrics;

    @Inject
    public AuthService(
            UserRepository userRepository,
            JwtService jwtService,
            AuthMetrics authMetrics,
            TokenRepository tokenRepository
    ) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.authMetrics = authMetrics;
        this.tokenRepository = tokenRepository;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        return this.authMetrics.loginTimer.record(() -> {
            String email = loginRequest.getEmail();
            logger.info("Login Request: email={} timestamp={}", email, System.currentTimeMillis());
            try {
                UserEntity user = this.userRepository.findByEmail(email)
                        .orElseThrow(() -> {
                            this.authMetrics.loginNotFound.increment();
                            return new ResourceNotFoundException("User does not exist");
                        });
                String token = generateToken(user);
                TokenEntity tokenEntity = new TokenEntity();
                tokenEntity.setToken(token);
                tokenEntity.setUserId(user.getId());
                tokenEntity.setExpiresAt(Instant.now());
                tokenRepository.save(tokenEntity);

                return new LoginResponse(token);
            } catch (ResourceNotFoundException ex) {
                logger.warn("Login Request: email={}, error is: {}", email, ex.getMessage());
                throw new ResourceNotFoundException(ex.getMessage());
            } catch (Exception ex) {
                this.authMetrics.loginError.increment();
                logger.warn("Internal error Login Request: email={}, error is: {}", email, ex);
                throw new AuthServiceException("Login failed due to internal error");
            }
        });
    }

    private String generateToken(UserEntity user) {
        return this.jwtService.generateToken(String.valueOf(user.getId()), user.getEmail());
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
