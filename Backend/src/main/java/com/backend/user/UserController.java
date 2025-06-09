package com.backend.user;

import com.backend.user.dto.RegisterRequest;
import com.backend.user.dto.RegisterResponse;
import com.backend.user.entity.UserEntity;
import jakarta.inject.Inject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "user")
public class UserController {
    private final UserService userService;

    @Inject
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "register")
    public ResponseEntity<  RegisterResponse> register(@RequestBody RegisterRequest registerRequest) {
        return ResponseEntity.ok(this.userService.register(registerRequest));
    }

    @PostMapping(value = "me")
    public ResponseEntity<Optional<UserEntity>> me(@RequestBody String token) {
        return ResponseEntity.ok(this.userService.me(token));
    }
}
