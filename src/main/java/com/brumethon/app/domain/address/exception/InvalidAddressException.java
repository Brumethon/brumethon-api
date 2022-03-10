package com.brumethon.app.domain.address.exception;

import com.brumethon.kernel.exception.SimpleServiceException;

public class InvalidAddressException extends SimpleServiceException {
    public InvalidAddressException(String message) {
        super(message);
    }
}
