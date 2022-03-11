package com.brumethon.app.expostion.error;

public class ErrorResponseDTO {
    private final String message;

    public ErrorResponseDTO(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
