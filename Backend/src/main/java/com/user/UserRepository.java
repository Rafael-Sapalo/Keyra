package com.user;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheRepository<UserEntity> {
    public UserEntity findByEmail(String email) {
        return find("email", email).firstResult();
    }

    public boolean existsByEmail(String email) {
        return count("email", email) > 0;
    }

    public void createUser(String email, String hashedPassword, String username) {
        UserEntity user = new UserEntity();
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(hashedPassword);
        persist(user);
    }
}
