package com.backend.jwt;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TokenRepository extends JpaRepository<TokenEntity, UUID> {
    Optional<TokenEntity> findByToken(String token);

    boolean existsByUserId(UUID userId);
}
