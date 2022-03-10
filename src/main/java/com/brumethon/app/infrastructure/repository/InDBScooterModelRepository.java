package com.brumethon.app.infrastructure.repository;

import com.brumethon.app.domain.scootermodel.ScooterModel;
import com.brumethon.app.domain.scootermodel.ScooterModelRepository;
import com.brumethon.app.infrastructure.database.scootermodel.ScooterModelDB;
import com.brumethon.app.infrastructure.database.scootermodel.ScooterModelDBRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InDBScooterModelRepository implements ScooterModelRepository {

    private final ScooterModelDBRepository dbRepository;

    public InDBScooterModelRepository(ScooterModelDBRepository dbRepository) {
        this.dbRepository = dbRepository;
    }

    @Override
    public Optional<ScooterModel> get(Long key) {
        Optional<ScooterModelDB> scooterModelDB = dbRepository.findById(key);

        if (scooterModelDB.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(scooterModelDB.get().toScooterModel());
    }

    @Override
    public Long add(ScooterModel value) {
        ScooterModelDB scooterModelDB = dbRepository.save(ScooterModelDB.of(value));
        value.setId(scooterModelDB.getId());
        return scooterModelDB.getId();
    }

    @Override
    public boolean update(ScooterModel value) {
        return false;
    }

    @Override
    public boolean remove(Long value) {
        dbRepository.deleteById(value);
        return dbRepository.existsById(value);
    }

    @Override
    public List<ScooterModel> getAll() {
        List<ScooterModel> list = new ArrayList<>();
        dbRepository.findAll().forEach(scooterModelDB -> list.add(scooterModelDB.toScooterModel()));
        return list;
    }
}
