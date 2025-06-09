package com.backend.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter @Getter
@ToString @EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    @JsonProperty(value = "email")
    private String email;

    @JsonProperty(value = "password")
    private String password;
}
