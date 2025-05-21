package com.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginRequestDTO {
    @JsonProperty("username")
    public String username;

    @JsonProperty("password")
    public String password;
}
