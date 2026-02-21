package com.example.Spring_JWT_CRUD.responses;

public class LoginResponse {
    private String token;
    private long expiresIn;
    private String getToken(){
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }
}
