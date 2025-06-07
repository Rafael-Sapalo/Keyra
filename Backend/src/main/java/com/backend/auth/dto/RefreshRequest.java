package com.backend.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.UUID;

@Data
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class RefreshRequest {
    @JsonProperty("user_id")
    private UUID userID;

    @JsonProperty("access_token")
    private String token;
}
