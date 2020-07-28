package com.api.user.dto;

public class UserToken {

    private String jwtToken;

    public UserToken() {
    }

    public UserToken(final String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return this.jwtToken;
    }

    public void setJwtToken(final String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
