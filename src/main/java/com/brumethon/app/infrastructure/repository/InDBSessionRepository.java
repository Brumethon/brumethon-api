package com.brumethon.app.infrastructure.repository;

import com.brumethon.app.domain.session.Session;
import com.brumethon.app.infrastructure.database.session.SessionDBRepository;
import com.brumethon.kernel.Repository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class InDBSessionRepository implements Repository<Session, Long> {

    private final SessionDBRepository dbRepository;

    public InDBSessionRepository(SessionDBRepository dbRepository) {
        this.dbRepository = dbRepository;
    }

    @Override
    public Optional<Session> get(Long key) {
        return Optional.empty();
    }

    @Override
    public Long add(Session value) {
        return null;
    }

    @Override
    public boolean update(Session value) {
        return false;
    }

    @Override
    public boolean remove(Long value) {
        return false;
    }

    @Override
    public List<Session> getAll() {
        return null;
    }
}
