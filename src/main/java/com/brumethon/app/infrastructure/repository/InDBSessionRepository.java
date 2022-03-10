package com.brumethon.app.infrastructure.repository;

import com.brumethon.app.domain.session.Session;
import com.brumethon.app.infrastructure.database.session.SessionDB;
import com.brumethon.app.infrastructure.database.session.SessionDBRepository;
import com.brumethon.kernel.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class InDBSessionRepository implements Repository<Session, String> {

    private final SessionDBRepository dbRepository;

    public InDBSessionRepository(SessionDBRepository dbRepository) {
        this.dbRepository = dbRepository;
    }

    @Override
    public Optional<Session> get(String key) {
        Optional<SessionDB> sessionDB = dbRepository.findById(key);

        if(sessionDB.isEmpty()){
            return Optional.empty();
        }

        return Optional.of( sessionDB.get().toSession());
    }

    @Override
    public String add(Session value) {
        SessionDB sessionDB = dbRepository.save(SessionDB.of(value));
        value.setId(sessionDB.getTokenId());
        return sessionDB.getTokenId();
    }

    @Override
    public boolean update(Session value) {
        return false;
    }

    @Override
    public boolean remove(String value) {
        dbRepository.deleteById(value);
        return dbRepository.existsById(value);
    }

    @Override
    public List<Session> getAll() {
        List<Session> list = new ArrayList<>();

        dbRepository.findAll().forEach(sessionDB -> list.add( sessionDB.toSession()));

        return list;
    }
}
