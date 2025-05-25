package com.jwt;

import io.smallrye.jwt.build.Jwt;
import io.smallrye.jwt.build.JwtClaimsBuilder;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JwtService {

    public String generateToken(String email) {
        JwtClaimsBuilder claims = Jwt.claims()
                .subject(email)
                .issuer("Keyra")
                .claim("role", "USER")
                .expiresAt(System.currentTimeMillis() / 1000 + 3600);

        return claims.sign();
    }
}
