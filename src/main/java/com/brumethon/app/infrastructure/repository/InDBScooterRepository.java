package com.brumethon.app.infrastructure.repository;

import com.brumethon.app.domain.scooter.Scooter;
import com.brumethon.app.domain.scooter.ScooterRepository;
import com.brumethon.app.infrastructure.database.scooter.ScooterDB;
import com.brumethon.app.infrastructure.database.scooter.ScooterDBRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InDBScooterRepository implements ScooterRepository {

    private final ScooterDBRepository dbRepository;

    public InDBScooterRepository(ScooterDBRepository dbRepository) {
        this.dbRepository = dbRepository;
    }

    @Override
    public Optional<Scooter> get(Long key) {
        Optional<ScooterDB> scooterDB = dbRepository.findById(key);

        if (scooterDB.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(scooterDB.get().toScooter());
    }

    @Override
    public Long add(Scooter value) {
        ScooterDB scooterDB = dbRepository.save(ScooterDB.of(value));
        value.setId(scooterDB.getId());
        return scooterDB.getId();
    }

    @Override
    public boolean update(Scooter value) {
        return false;
    }

    @Override
    public boolean remove(Long value) {
        dbRepository.deleteById(value);
        return dbRepository.existsById(value);
    }

    @Override
    public List<Scooter> getAll() {
        List<Scooter> list = new ArrayList<>();
        dbRepository.findAll().forEach(scooterDB -> list.add(scooterDB.toScooter()));
        return list;
    }
}
