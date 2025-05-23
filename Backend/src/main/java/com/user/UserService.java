package com.user;

import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UserService {

    UserRepository userRepository;

    @Inject
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public String registerUser(String username, String password, String email) {
        if (this.userRepository.existsByEmail(email)) {
            return null;
        }
        this.userRepository.createUser(username, BcryptUtil.bcryptHash(password), email);
        return "success";
    }
}
