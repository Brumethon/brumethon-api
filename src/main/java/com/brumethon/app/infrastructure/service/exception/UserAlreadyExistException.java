package com.brumethon.app.infrastructure.service.exception;

import com.brumethon.kernel.exception.SimpleServiceException;

public class UserAlreadyExistException extends SimpleServiceException {
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
