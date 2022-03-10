package com.brumethon.app.domain.scooter;

import com.brumethon.app.domain.scooter.exception.InvalidScooterException;
import com.brumethon.app.domain.scootermodel.ScooterModelValidator;
import com.brumethon.kernel.Validator;

public class ScooterValidator implements Validator<Scooter> {

    private final ScooterModelValidator scooterModelValidator;

    public ScooterValidator(ScooterModelValidator scooterModelValidator) {
        this.scooterModelValidator = scooterModelValidator;
    }

    @Override
    public void validate(Scooter scooter) {
        if(scooter == null) {
            throw new IllegalArgumentException("User to validate is null");
        }

        if(scooter.getSerialID() == null || scooter.getSerialID().isEmpty()){
            throw new InvalidScooterException("scooter serial ID can not be empty");
        }

        if( scooter.getPurchaseDate() == null){
            throw new InvalidScooterException("scooter purchase date can not be empty");
        }

        if(scooter.getModel() == null){
            throw new InvalidScooterException("scooter model can not be empty");
        }

        scooterModelValidator.validate(scooter.getModel());

    }
}
