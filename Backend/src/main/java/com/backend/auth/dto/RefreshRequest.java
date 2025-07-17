package com.backend.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class RefreshRequest {
    @JsonProperty("access_token")
    private String accessToken;
}
