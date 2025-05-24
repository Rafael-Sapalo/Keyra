package com.jwt;

import io.smallrye.jwt.build.Jwt;
import io.smallrye.jwt.build.JwtClaimsBuilder;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class JwtService {

    public String generateToken(UUID userID) {
        JwtClaimsBuilder claims = Jwt.claims()
                .subject(userID.toString())
                .issuer("Keyra")
                .claim("role", "USER")
                .expiresAt(System.currentTimeMillis() / 1000 + 3600);

        return claims.sign();
    }
}
