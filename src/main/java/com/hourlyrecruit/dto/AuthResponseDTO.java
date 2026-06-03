package com.hourlyrecruit.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthResponseDTO {

    private String accessToken;

    private String refreshToken;

    private String message;

    public AuthResponseDTO() {
        super();
    }

    // For login response
    public AuthResponseDTO(
            String accessToken,
            String refreshToken,
            String message) {

        super();

        this.accessToken = accessToken;

        this.refreshToken = refreshToken;

        this.message = message;
    }

    // For token-only response
    public AuthResponseDTO(
            String accessToken,
            String refreshToken) {

        super();

        this.accessToken = accessToken;

        this.refreshToken = refreshToken;
    }

    // For message-only response
    public AuthResponseDTO(String message) {

        super();

        this.message = message;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(
            String accessToken) {

        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(
            String refreshToken) {

        this.refreshToken = refreshToken;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(
            String message) {

        this.message = message;
    }
}