package com.user;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class UserRepository implements PanacheRepository<UserEntity> {
    public UserEntity findByEmail(String email) {
        return find("email", email).firstResult();
    }

    public UserEntity findById(UUID id) {
        return find("id", id).firstResult();
    }

    public void createUser(String email, String hashedPassword, String username) {
        UserEntity user = new UserEntity();
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(hashedPassword);
        persist(user);
    }
}
