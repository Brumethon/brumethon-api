package com.brumethon.app.infrastructure.repository;

import com.brumethon.app.domain.session.Session;
import com.brumethon.app.domain.session.SessionRepository;
import com.brumethon.app.infrastructure.database.session.SessionDB;
import com.brumethon.app.infrastructure.database.session.SessionDBRepository;
import com.brumethon.app.infrastructure.database.user.UserDB;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@org.springframework.stereotype.Repository
public class InDBSessionRepository implements SessionRepository {

    private final SessionDBRepository dbRepository;
    private final InDBUserRepository inDBUserRepository;

    public InDBSessionRepository(SessionDBRepository dbRepository, InDBUserRepository inDBUserRepository) {
        this.dbRepository = dbRepository;
        this.inDBUserRepository = inDBUserRepository;
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

    @Override
    public void removeAllForUserID(Long userID) {
        dbRepository.deleteAllByUserID(userID);
    }

    @Override
    public Optional<Session> get(UUID id) {
        SessionDB sessionDB = dbRepository.findById(id.toString()).orElseThrow();

        return Optional.of(sessionDB.toSession());
    }
}
