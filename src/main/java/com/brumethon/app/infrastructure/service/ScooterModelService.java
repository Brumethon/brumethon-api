package com.brumethon.app.infrastructure.service;

import com.brumethon.app.domain.scootermodel.ScooterModel;
import com.brumethon.app.domain.scootermodel.ScooterModelRepository;
import com.brumethon.kernel.SimpleService;
import com.brumethon.kernel.Validator;

public class ScooterModelService extends SimpleService<ScooterModelRepository, ScooterModel, Long> {

    public ScooterModelService(ScooterModelRepository repository, Validator<ScooterModel> validator) {
        super(repository, validator, "scooter model");
    }
}
