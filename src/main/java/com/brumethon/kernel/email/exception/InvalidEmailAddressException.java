package com.brumethon.kernel.email.exception;


import com.brumethon.kernel.email.EmailAddress;

public class InvalidEmailAddressException extends EmailAddressException{
    public InvalidEmailAddressException(EmailAddress emailAddress) {
        super("email " + emailAddress.toString() + " is invalid");
    }
}
