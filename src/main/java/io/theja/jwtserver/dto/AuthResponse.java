package io.theja.jwtserver.dto;

// TODO 11: Add auth response DTO.
public class AuthResponse {

    private String tokenMsg;

    public AuthResponse() {
    }

    public AuthResponse(String token) {
        this.tokenMsg = token;
    }

    public String getTokenMsg() {
        return tokenMsg;
    }

    public void setTokenMsg(String tokenMsg) {
        this.tokenMsg = tokenMsg;
    }

}
