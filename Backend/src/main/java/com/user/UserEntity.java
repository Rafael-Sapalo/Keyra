package com.user;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "UUID", updatable = false, nullable = false)
    public UUID id;

    @Column(length = 255, nullable = false, unique = true)
    public String email;

    @Column(length = 255, nullable = false)
    public String username;

    @Column(name = "password", nullable = false)
    public String password;

    @Column(name = "first_name", length = 255)
    public String firsName;

    @Column(name = "last_name", length = 255)
    public String lastName;

    @Column(name = "phone_number", length = 20)
    public String phoneNumber;

    @Column(columnDefinition = "TEXT")
    public String bio;

    @Column(columnDefinition = "TEXT")
    public String pfp;

    @Column(name = "is_verified", nullable = false)
    public boolean isVerified = false;

    @Column(name = "is_active", nullable = false)
    public boolean isActive = true;

    @Column(name = "is_banned", nullable = false)
    public boolean isBanned = false;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    public LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    public LocalDateTime updatedAt;


    public UUID getId() { return this.id; }

    public void setEmail(String email) { this.email = email; }
    public String getEmail() { return email; }

    public void setUsername(String username) { this.username = username; }
    public String getUsername() { return username; }

    public void setPassword(String password) { this.password = password; }
    public String getPassword() { return password;}

    @PrePersist
    protected void prePersist() {
        if (id == null) id = UUID.randomUUID();
        if (createdAt == null) createdAt = LocalDateTime.now();
        if (updatedAt == null) updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void preUpdate() {
        if (updatedAt == null) updatedAt = LocalDateTime.now();
    }
}
