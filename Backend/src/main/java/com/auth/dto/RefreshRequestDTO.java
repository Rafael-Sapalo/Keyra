package com.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RefreshRequestDTO {
    @JsonProperty("refresh_token")
    public String refreshToken;

    public String getRefreshToken() {
        return refreshToken;
    }
}
