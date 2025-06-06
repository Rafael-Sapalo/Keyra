package com.backend.auth;

import com.backend.auth.dto.LoginRequest;
import com.backend.auth.dto.LoginResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("auth")
public class AuthController {

    @PostMapping(value = "login", produces = "application/json")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        if (loginRequest == null || loginRequest.getEmail() == null || loginRequest.getPassword() == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(new LoginResponse("TOKEN"));
    }

    @PostMapping(value = "refresh", produces = "application/json")
    public ResponseEntity<?> refresh() {
        return ResponseEntity.ok("refresh");
    }

    @PostMapping(value = "logout", produces = "application/json")
    public ResponseEntity<?> logout() {
        return ResponseEntity.ok("logout");
    }
}
