package com.brumethon.app.domain.scooter;

import com.brumethon.app.domain.address.Address;
import com.brumethon.app.domain.address.AddressValidator;
import com.brumethon.app.domain.scooter.exception.InvalidScooterException;
import com.brumethon.app.domain.scootermodel.ScooterModel;
import com.brumethon.app.domain.scootermodel.ScooterModelValidator;
import com.brumethon.app.domain.user.User;
import com.brumethon.app.domain.user.UserValidator;
import com.brumethon.kernel.email.EmailAddress;
import com.brumethon.kernel.email.SimpleEmailAddressValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class ScooterValidatorTest {

    static ScooterValidator scooterValidator;
    static User defaultValidUser;

    @BeforeAll
    static void beforeAll(){
        scooterValidator = new ScooterValidator(new ScooterModelValidator(), new UserValidator(new AddressValidator(), new SimpleEmailAddressValidator()));
        defaultValidUser = new User(1L, new EmailAddress("test@test.com"), "bob", "bob", "p",
                                    "0601020304", new Address(1L, "", "", "", "", "", 0.0, 0.0));
    }

    @Test
    void should_be_valid(){
        Scooter scooter = new Scooter("s", new ScooterModel("model1"), defaultValidUser, LocalDate.now());
        Assertions.assertDoesNotThrow(() -> scooterValidator.validate(scooter));
    }

    @Test
    void should_not_be_valid_with_null_serialID(){
        Scooter scooter = new Scooter(null, new ScooterModel("model1"), defaultValidUser, LocalDate.now());
        Assertions.assertThrows(InvalidScooterException.class, () -> scooterValidator.validate(scooter));
    }

    @Test
    void should_not_be_valid_with_empty_serialID(){
        Scooter scooter = new Scooter("", new ScooterModel("model1"), defaultValidUser, LocalDate.now());
        Assertions.assertThrows(InvalidScooterException.class, () -> scooterValidator.validate(scooter));
    }

    @Test
    void should_not_be_valid_with_null_model(){
        Scooter scooter = new Scooter("s", null, defaultValidUser, LocalDate.now());
        Assertions.assertThrows(InvalidScooterException.class, () -> scooterValidator.validate(scooter));
    }

    @Test
    void should_not_be_valid_with_null_purchase_date(){
        Scooter scooter = new Scooter("s", new ScooterModel("model1"), defaultValidUser, null);
        Assertions.assertThrows(InvalidScooterException.class, () -> scooterValidator.validate(scooter));
    }

    @Test
    void should_not_be_valid_with_null_owner(){
        Scooter scooter = new Scooter("s", new ScooterModel("model1"), null, null);
        Assertions.assertThrows(InvalidScooterException.class, () -> scooterValidator.validate(scooter));
    }

}
