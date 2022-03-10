package com.brumethon.app.domain.scooter;

import com.brumethon.app.domain.scooter.exception.InvalidScooterException;
import com.brumethon.app.domain.scootermodel.ScooterModel;
import com.brumethon.app.domain.scootermodel.ScooterModelValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ScooterValidatorTest {

    static ScooterValidator scooterValidator;

    @BeforeAll
    static void beforeAll(){
        scooterValidator = new ScooterValidator(new ScooterModelValidator());
    }

    @Test
    void should_be_valid(){
        Scooter scooter = new Scooter("s", new ScooterModel("model1"), LocalDate.now());
        Assertions.assertDoesNotThrow(() -> scooterValidator.validate(scooter));
    }

    @Test
    void should_not_be_valid_with_null_serialID(){
        Scooter scooter = new Scooter(null, new ScooterModel("model1"), LocalDate.now());
        Assertions.assertThrows(InvalidScooterException.class, () -> scooterValidator.validate(scooter));
    }

    @Test
    void should_not_be_valid_with_empty_serialID(){
        Scooter scooter = new Scooter("", new ScooterModel("model1"), LocalDate.now());
        Assertions.assertThrows(InvalidScooterException.class, () -> scooterValidator.validate(scooter));
    }

    @Test
    void should_not_be_valid_with_null_model(){
        Scooter scooter = new Scooter("s", null, LocalDate.now());
        Assertions.assertThrows(InvalidScooterException.class, () -> scooterValidator.validate(scooter));
    }

    @Test
    void should_not_be_valid_with_null_purchase_date(){
        Scooter scooter = new Scooter("s", new ScooterModel("model1"), null);
        Assertions.assertThrows(InvalidScooterException.class, () -> scooterValidator.validate(scooter));
    }

}