package com.brumethon.kernel.email;

import com.brumethon.kernel.email.exception.InvalidEmailAddressException;
import org.apache.commons.validator.routines.EmailValidator;

public class SimpleEmailAddressValidator implements EmailAddressValidator {
    @Override
    public void validate(EmailAddress emailAddress) {
        if (emailAddress == null) throw new IllegalArgumentException("emailAddress to validate is null");

        EmailValidator validator = EmailValidator.getInstance();
        if (!validator.isValid(emailAddress.toString())) {
            throw new InvalidEmailAddressException(emailAddress);
        }
    }
}
