package com.a505.hobbyit.common.exception.dto;

public class ErrorResponse {
    private final String message;

    public ErrorResponse(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
