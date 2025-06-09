package com.backend.auth;

import com.backend.auth.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = "login", produces = "application/json")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        if (loginRequest == null || loginRequest.getEmail() == null || loginRequest.getPassword() == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        LoginResponse token = this.authService.login(loginRequest);
        if  (token == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginResponse(null));
        }
        return ResponseEntity.ok(new LoginResponse(token));
    }

    @PostMapping(value = "refresh", produces = "application/json")
    public ResponseEntity<String> refresh(@RequestBody RefreshRequest refreshRequest) {
        return ResponseEntity.ok("done");
    }

    @PostMapping(value = "logout", produces = "application/json")
    public ResponseEntity<LogoutResponse> logout() {
        return ResponseEntity.ok(new LogoutResponse(this.authService.logout()));
    }
}
