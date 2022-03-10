package com.brumethon.app.domain.scootermodel;

import com.brumethon.app.domain.scootermodel.exception.InvalidScooterModelException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ScooterModelValidatorTest {

    static ScooterModelValidator scooterModelValidator;

    @BeforeAll
    static void beforeAll() {
        scooterModelValidator = new ScooterModelValidator();
    }

    @Test
    void should_be_valid() {
        ScooterModel scooterModel = new ScooterModel("model1");
        Assertions.assertDoesNotThrow(() -> scooterModelValidator.validate(scooterModel));
    }

    @Test
    void should_not_be_valid_with_null_name() {
        ScooterModel scooterModel = new ScooterModel(null);
        Assertions.assertThrows(InvalidScooterModelException.class, () -> scooterModelValidator.validate(scooterModel));
    }

    @Test
    void should_not_be_valid_with_empty_name() {
        ScooterModel scooterModel = new ScooterModel("");
        Assertions.assertThrows(InvalidScooterModelException.class, () -> scooterModelValidator.validate(scooterModel));
    }

}