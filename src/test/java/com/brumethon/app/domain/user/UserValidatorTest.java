package com.brumethon.app.domain.user;

import com.brumethon.app.domain.address.Address;
import com.brumethon.app.domain.address.AddressValidator;
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
    static String defaultValidPhoneNumber;
    static Address defaultValidAddress;

    @BeforeAll
    static void beforeAll(){
        userValidator = new UserValidator( new AddressValidator(), new SimpleEmailAddressValidator());
        defaultValidEmailAddress = new EmailAddress("test@test.com");
        defaultValidFirstName = "Bob";
        defaultValidLastName = "Marley";
        defaultValidPassword = "p";
        defaultValidPhoneNumber = "0601020304";
        defaultValidAddress = new Address(1L, "", "", "", "", "", 0.0, 0.0);
    }

    @Test
    void should_be_valid(){
        User user = new User(1L, defaultValidEmailAddress, defaultValidFirstName, defaultValidLastName, defaultValidPassword, defaultValidPhoneNumber, defaultValidAddress);
        Assertions.assertDoesNotThrow(() -> userValidator.validate(user));
    }

    @Test
    void should_not_be_valid_with_null_email_address(){
        User user = new User(1L, null, defaultValidFirstName, defaultValidLastName, defaultValidPassword, defaultValidPhoneNumber, defaultValidAddress);
        Assertions.assertThrows(InvalidUserException.class, () -> userValidator.validate(user));
    }

    @Test
    void should_not_be_valid_with_empty_email_address(){
        User user = new User(1L, new EmailAddress(""), defaultValidFirstName, defaultValidLastName, defaultValidPassword, defaultValidPhoneNumber, defaultValidAddress);
        Assertions.assertThrows(InvalidUserException.class, () -> userValidator.validate(user));
    }

    @Test
    void should_not_be_valid_with_null_first_name(){
        User user = new User(1L, defaultValidEmailAddress, null, defaultValidLastName, defaultValidPassword, defaultValidPhoneNumber, defaultValidAddress);
        Assertions.assertThrows(InvalidUserException.class, () -> userValidator.validate(user));
    }

    @Test
    void should_not_be_valid_with_empty_first_name(){
        User user = new User(1L, defaultValidEmailAddress, "", defaultValidLastName, defaultValidPassword, defaultValidPhoneNumber, defaultValidAddress);
        Assertions.assertThrows(InvalidUserException.class, () -> userValidator.validate(user));
    }

    @Test
    void should_not_be_valid_with_null_last_name(){
        User user = new User(1L, defaultValidEmailAddress, defaultValidFirstName, null, defaultValidPassword, defaultValidPhoneNumber, defaultValidAddress);
        Assertions.assertThrows(InvalidUserException.class, () -> userValidator.validate(user));
    }

    @Test
    void should_not_be_valid_with_empty_last_name(){
        User user = new User(1L, defaultValidEmailAddress, defaultValidFirstName, "", defaultValidPassword, defaultValidPhoneNumber, defaultValidAddress);
        Assertions.assertThrows(InvalidUserException.class, () -> userValidator.validate(user));
    }

    @Test
    void should_not_be_valid_with_null_password(){
        User user = new User(1L, defaultValidEmailAddress, defaultValidFirstName, defaultValidLastName, null, defaultValidPhoneNumber, defaultValidAddress);
        Assertions.assertThrows(InvalidUserException.class, () -> userValidator.validate(user));
    }

    @Test
    void should_not_be_valid_with_empty_password(){
        User user = new User(1L, defaultValidEmailAddress, defaultValidFirstName, defaultValidLastName, "", defaultValidPhoneNumber, defaultValidAddress);
        Assertions.assertThrows(InvalidUserException.class, () -> userValidator.validate(user));
    }

    @Test
    void should_not_be_valid_with_null_address(){
        User user = new User(1L, defaultValidEmailAddress, defaultValidFirstName, defaultValidLastName, defaultValidPassword, defaultValidPhoneNumber, null);
        Assertions.assertThrows(InvalidUserException.class, () -> userValidator.validate(user));
    }

}
