package com.brumethon.app.infrastructure.repository;

import com.brumethon.app.domain.scooter.Scooter;
import com.brumethon.app.domain.scooter.ScooterRepository;

import java.util.List;
import java.util.Optional;

public class InDBScooterRepository implements ScooterRepository {
    @Override
    public Optional<Scooter> get(String key) {
        return Optional.empty();
    }

    @Override
    public String add(Scooter value) {
        return null;
    }

    @Override
    public boolean update(Scooter value) {
        return false;
    }

    @Override
    public boolean remove(String value) {
        return false;
    }

    @Override
    public List<Scooter> getAll() {
        return null;
    }
}
