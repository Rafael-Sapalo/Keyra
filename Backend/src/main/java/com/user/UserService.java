package com.user;

import com.jwt.JwtService;
import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;

import java.util.UUID;

@ApplicationScoped
public class UserService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    @Inject
    public UserService(UserRepository userRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    @Transactional
    public String registerUser(String username, String password, String email) {
        try {
            String hashedPassword = BcryptUtil.bcryptHash(password);
            this.userRepository.createUser(email, hashedPassword, username);
            return this.jwtService.generateToken(email);
        } catch (PersistenceException e) {
            return null;
        }
    }

    @Transactional
    public UserEntity getUserInfo(UUID userId) {
        return this.userRepository.findById(userId);
    }
}
