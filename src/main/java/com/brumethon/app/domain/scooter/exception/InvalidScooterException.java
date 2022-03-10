package com.brumethon.app.domain.scooter.exception;

import com.brumethon.kernel.exception.SimpleServiceException;

public class InvalidScooterException extends SimpleServiceException {
    public InvalidScooterException(String message) {
        super(message);
    }
}
