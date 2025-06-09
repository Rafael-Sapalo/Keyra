package com.backend.user;

import com.backend.exception.ConflictException;
import com.backend.user.dto.RegisterRequest;
import com.backend.user.dto.RegisterResponse;
import com.backend.user.entity.UserEntity;
import com.backend.user.repository.UserRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Inject
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(rollbackOn = Exception.class)
    public RegisterResponse register(RegisterRequest registerRequest) {
        if (this.userRepository.existsByEmail(registerRequest.getEmail())) {
            throw new ConflictException("Email already exists");
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(registerRequest.getUsername());
        userEntity.setPassword(registerRequest.getPassword());
        userEntity.setEmail(registerRequest.getEmail());

        UserEntity savedUser = this.userRepository.save(userEntity);
        return new RegisterResponse(
                savedUser.getId(),
                savedUser.getUsername(),
                savedUser.getEmail(),
                "User registered successfully"
        );
    }
}
