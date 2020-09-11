package com.example.groupproject1.model;

import java.io.Serializable;

public class UserResponse implements Serializable {
    private final String jwt;

    public UserResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
