package com.brumethon.app.domain.scootermodel.exception;

import com.brumethon.kernel.exception.SimpleServiceException;

public class InvalidScooterModelException extends SimpleServiceException {
    public InvalidScooterModelException(String message) {
        super(message);
    }
}
