package com.user;

import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;

import java.util.UUID;

@ApplicationScoped
public class UserService {

    UserRepository userRepository;

    @Inject
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public String registerUser(String username, String password, String email) {
        try {
            String hashedPassword = BcryptUtil.bcryptHash(password);
            this.userRepository.createUser(username, hashedPassword, email);
            return hashedPassword;
        } catch (PersistenceException e) {
            return null;
        }
    }

    @Transactional
    public UserEntity getUserInfo(UUID userId) {
        return this.userRepository.findById(userId);
    }
}
