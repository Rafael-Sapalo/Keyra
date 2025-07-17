package com.backend.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RefreshResponse {
    @JsonProperty("access_token")
    private String token;
}
