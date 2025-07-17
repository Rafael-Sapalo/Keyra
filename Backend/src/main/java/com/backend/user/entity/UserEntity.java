package com.backend.user.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "UUID", updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String password;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    @Column(columnDefinition = "TEXT")
    private String bio;

    private String pfp;

    @Builder.Default
    private boolean isVerified = false;

    @Builder.Default
    private boolean isActive = true;

    @Builder.Default
    private boolean isBanned = false;

    @Column(updatable = false)
    private Instant createdAt;

    private Instant updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = Instant.now();
    }
}
