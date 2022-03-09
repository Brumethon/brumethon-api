package com.brumethon.app.domain.user;

import com.brumethon.app.domain.user.exception.InvalidUserException;
import com.brumethon.kernel.email.EmailAddress;
import com.brumethon.kernel.email.SimpleEmailAddressValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class UserValidatorTest {

    static UserValidator userValidator;
    static EmailAddress defaultValidEmailAddress;
    static String defaultValidFirstName;
    static String defaultValidLastName;
    static String defaultValidPassword;

    @BeforeAll
    static void beforeAll(){
        userValidator = new UserValidator(new SimpleEmailAddressValidator());
        defaultValidEmailAddress = new EmailAddress("test@test.com");
        defaultValidFirstName = "Bob";
        defaultValidLastName = "Marley";
        defaultValidPassword = "p";
    }

    @Test
    void should_be_valid(){
        User user = new User(1, defaultValidEmailAddress, defaultValidFirstName, defaultValidLastName, defaultValidPassword);
        Assertions.assertDoesNotThrow(() -> userValidator.validate(user));
    }

    @Test
    void should_not_be_valid_with_null_email_address(){
        User user = new User(1, null, defaultValidFirstName, defaultValidLastName, defaultValidPassword);
        Assertions.assertThrows(InvalidUserException.class, () -> userValidator.validate(user));
    }

    @Test
    void should_not_be_valid_with_empty_email_address(){
        User user = new User(1, new EmailAddress(""), defaultValidFirstName, defaultValidLastName, defaultValidPassword);
        Assertions.assertThrows(InvalidUserException.class, () -> userValidator.validate(user));
    }

    @Test
    void should_not_be_valid_with_null_first_name(){
        User user = new User(1, defaultValidEmailAddress, null, defaultValidLastName, defaultValidPassword);
        Assertions.assertThrows(InvalidUserException.class, () -> userValidator.validate(user));
    }

    @Test
    void should_not_be_valid_with_empty_first_name(){
        User user = new User(1, defaultValidEmailAddress, "", defaultValidLastName, defaultValidPassword);
        Assertions.assertThrows(InvalidUserException.class, () -> userValidator.validate(user));
    }

    @Test
    void should_not_be_valid_with_null_last_name(){
        User user = new User(1, defaultValidEmailAddress, defaultValidFirstName, null, defaultValidPassword);
        Assertions.assertThrows(InvalidUserException.class, () -> userValidator.validate(user));
    }

    @Test
    void should_not_be_valid_with_empty_last_name(){
        User user = new User(1, defaultValidEmailAddress, defaultValidFirstName, "", defaultValidPassword);
        Assertions.assertThrows(InvalidUserException.class, () -> userValidator.validate(user));
    }

    @Test
    void should_not_be_valid_with_null_password(){
        User user = new User(1, defaultValidEmailAddress, defaultValidFirstName, defaultValidLastName, null);
        Assertions.assertThrows(InvalidUserException.class, () -> userValidator.validate(user));
    }

    @Test
    void should_not_be_valid_with_empty_password(){
        User user = new User(1, defaultValidEmailAddress, defaultValidFirstName, defaultValidLastName, "");
        Assertions.assertThrows(InvalidUserException.class, () -> userValidator.validate(user));
    }

}