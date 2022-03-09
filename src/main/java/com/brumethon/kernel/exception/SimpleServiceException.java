package com.brumethon.kernel.exception;

public class SimpleServiceException extends RuntimeException{
    public SimpleServiceException(String message) {
        super(message);
    }
}
