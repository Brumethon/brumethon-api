package com.brumethon.app.domain.scootermodel;

import com.brumethon.app.domain.scootermodel.exception.InvalidScooterModelException;
import com.brumethon.kernel.Validator;

public class ScooterValidator implements Validator<ScooterModel> {

    @Override
    public void validate(ScooterModel scooterModel) {
        if(scooterModel == null) {
            throw new IllegalArgumentException("ScooterModel to validate is null");
        }

        if( scooterModel.getDescription() == null || scooterModel.getDescription().isEmpty()) {
            throw new InvalidScooterModelException("Scooter model description can not be empty");
        }

        if( scooterModel.getName() == null || scooterModel.getName().isEmpty()) {
            throw new InvalidScooterModelException("Scooter model name can not be empty");
        }
    }

}
