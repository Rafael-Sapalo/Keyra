package com.user;

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
    public UserEntity registerUser(String username, String password, String email) {
        UserEntity user = new UserEntity();
        if (this.userRepository.existsByEmail(email)) {
            return null;
        }
        user.setUsername(username);
        user.password = password;
        user.email = email;
        this.userRepository.createUser();
        return user;
    }
}
