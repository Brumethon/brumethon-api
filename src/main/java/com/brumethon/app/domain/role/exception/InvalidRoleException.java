package com.brumethon.app.domain.role.exception;

import com.brumethon.kernel.exception.SimpleServiceException;

public class InvalidRoleException extends SimpleServiceException{
    public InvalidRoleException(String message) {
        super(message);
    }
}
