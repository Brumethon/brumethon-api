package com.brumethon.app.domain.scootermodel;

import com.brumethon.kernel.Repository;

import java.util.Optional;

public interface ScooterModelRepository extends Repository<ScooterModel, Long> {

    Optional<ScooterModel> getByName(String name);
}
