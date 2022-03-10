package com.brumethon.app.infrastructure.repository;

import com.brumethon.app.domain.scootermodel.ScooterModel;
import com.brumethon.app.domain.scootermodel.ScooterModelRepository;

import java.util.List;
import java.util.Optional;

public class InDBScooterModelRepository implements ScooterModelRepository {
    @Override
    public Optional<ScooterModel> get(Long key) {
        return Optional.empty();
    }

    @Override
    public Long add(ScooterModel value) {
        return null;
    }

    @Override
    public boolean update(ScooterModel value) {
        return false;
    }

    @Override
    public boolean remove(Long value) {
        return false;
    }

    @Override
    public List<ScooterModel> getAll() {
        return null;
    }
}
