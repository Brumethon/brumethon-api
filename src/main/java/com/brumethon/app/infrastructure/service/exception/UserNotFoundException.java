package com.brumethon.app.infrastructure.service.exception;

import com.brumethon.kernel.exception.SimpleServiceException;

public class UserNotFoundException extends SimpleServiceException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
