package com.backend.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    @PostMapping(value = "login", produces = "application/json")
    public String login() {
        return "login";
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
