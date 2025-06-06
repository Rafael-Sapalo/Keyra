package com.backend.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter @AllArgsConstructor
public class RefreshRequest {
    @JsonProperty("user_id")
    private UUID userID;

    @JsonProperty("access_token")
    private String token;
}
