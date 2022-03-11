package com.brumethon.app.infrastructure.service;

import com.brumethon.app.domain.session.Session;
import com.brumethon.app.domain.session.SessionRepository;
import com.brumethon.kernel.SimpleService;
import com.brumethon.kernel.Validator;
import com.brumethon.kernel.exception.SimpleServiceObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class SessionService extends SimpleService<SessionRepository, Session, String> {
    public SessionService(SessionRepository repository, Validator<Session> validator) {
        super(repository, validator, "session");
    }

    private boolean isExpired(LocalDateTime dateTime) {
        return LocalDateTime.now().isAfter(dateTime);
    }


    @Override
    public Session get(String key) {
        Session session = super.get(key);
        if (isExpired(session.getExpirationDate())) {
            repository.removeAllForUserID(session.getUser().getID());
            throw  new SimpleServiceObjectNotFoundException("session", key);
        }
        return session;
    }

    public void removeAllForUserID(Long user_id) {
        repository.removeAllForUserID(user_id);
    }
}
