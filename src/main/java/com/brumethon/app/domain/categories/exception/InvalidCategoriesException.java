package com.brumethon.app.domain.categories.exception;

import com.brumethon.kernel.exception.SimpleServiceException;

public class InvalidCategoriesException extends SimpleServiceException {
    public InvalidCategoriesException(String message) {
        super(message);
    }
}
