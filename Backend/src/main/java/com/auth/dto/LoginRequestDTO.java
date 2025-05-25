package com.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginRequestDTO {
    @JsonProperty("email")
    public String email;

    @JsonProperty("password")
    public String password;
}
