package com.brumethon.app.domain.role.exception;

import com.brumethon.app.domain.role.Role;
import com.brumethon.kernel.Validator;
import com.brumethon.kernel.exception.SimpleServiceException;

public class InvalidRoleException extends SimpleServiceException{
    public InvalidRoleException(String message) {
        super(message);
    }
}
