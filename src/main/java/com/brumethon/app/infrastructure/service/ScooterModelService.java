package com.brumethon.app.infrastructure.service;

import com.brumethon.app.domain.scootermodel.ScooterModel;
import com.brumethon.app.domain.scootermodel.ScooterModelRepository;
import com.brumethon.kernel.SimpleService;
import com.brumethon.kernel.Validator;
import com.brumethon.kernel.exception.SimpleServiceException;
import com.brumethon.kernel.exception.SimpleServiceObjectAlreadyException;

public class ScooterModelService extends SimpleService<ScooterModelRepository, ScooterModel, String> {

    public ScooterModelService(ScooterModelRepository repository, Validator<ScooterModel> validator) {
        super(repository, validator);
    }

    @Override
    public SimpleServiceException getExceptionWhenObjectNotFound(String key) {
        return new SimpleServiceObjectAlreadyException("scooter model", key);
    }

    @Override
    public SimpleServiceException getExceptionWhenObjectAlreadyPresent(String key) {
        return new SimpleServiceObjectAlreadyException("scooter model", key);
    }
}
