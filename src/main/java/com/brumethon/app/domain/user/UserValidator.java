package com.brumethon.app.domain.user;

import com.brumethon.app.domain.user.exception.InvalidUserException;
import com.brumethon.kernel.Validator;
import com.brumethon.kernel.email.EmailAddressValidator;

public class UserValidator implements Validator<User> {

    private final EmailAddressValidator emailValidator;

    public UserValidator(EmailAddressValidator emailValidator) {
        this.emailValidator = emailValidator;
    }

    @Override
    public void validate(User user) {
        if(user == null) {
            throw new IllegalArgumentException("User to validate is null");
        }

        if(user.getEmailAddress() == null || user.getEmailAddress().toString().isEmpty()){
            throw new InvalidUserException("User email address can not be empty");
        }

        if(user.getFirstName() == null || user.getFirstName().isEmpty()){
            throw new InvalidUserException("User first name can not be empty");
        }

        if(user.getLastName() == null || user.getLastName().isEmpty()){
            throw new InvalidUserException("User last name can not be empty");
        }

        if(user.getPassword() == null || user.getPassword().isEmpty()){
            throw new InvalidUserException("User password can not be empty");
        }

        emailValidator.validate(user.getEmailAddress());

    }
}
