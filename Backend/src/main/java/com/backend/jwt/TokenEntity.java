package com.backend.jwt;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
import java.time.Instant;

@Entity
@Table(name = "token")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class TokenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "UUID", updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false, unique = true, name = "user_id")
    private UUID userId;

    @Column(nullable = false, unique = true)
    private String token;

    @Column(nullable = false)
    private Instant createdAt;
    @Column(nullable = false)
    private Instant expiresAt;

    @Column(nullable = false)
    private boolean revoked;

    @PrePersist
    protected void onCreate() {
        this.createdAt = Instant.now();
    }

}
