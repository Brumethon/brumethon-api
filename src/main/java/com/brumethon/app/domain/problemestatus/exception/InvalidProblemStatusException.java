package com.brumethon.app.domain.problemestatus.exception;

import com.brumethon.kernel.exception.SimpleServiceException;

public class InvalidProblemStatusException extends SimpleServiceException {
    public InvalidProblemStatusException(String message) {
        super(message);
    }
}
