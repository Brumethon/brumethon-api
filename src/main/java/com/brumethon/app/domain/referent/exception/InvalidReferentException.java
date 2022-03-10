package com.brumethon.app.domain.referent.exception;

import com.brumethon.kernel.exception.SimpleServiceException;

public class InvalidReferentException extends SimpleServiceException {
    public InvalidReferentException(String message) {
        super(message);
    }
}
