package com.brumethon.app.infrastructure.service;

import com.brumethon.app.domain.scooter.Scooter;
import com.brumethon.app.domain.scooter.ScooterRepository;
import com.brumethon.kernel.SimpleService;
import com.brumethon.kernel.Validator;

public class ScooterService extends SimpleService<ScooterRepository, Scooter, Long> {
    public ScooterService(ScooterRepository repository, Validator<Scooter> validator) {
        super(repository, validator, "scooter");
    }

}
