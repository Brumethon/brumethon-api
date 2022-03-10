package com.brumethon.app.domain.problem.exception;

import com.brumethon.kernel.exception.SimpleServiceException;

public class InvalidProblemException extends SimpleServiceException {
    public InvalidProblemException(String message) {
        super(message);
    }
}
