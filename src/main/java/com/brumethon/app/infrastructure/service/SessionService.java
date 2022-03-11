package com.brumethon.app.infrastructure.service;

import com.brumethon.app.domain.session.Session;
import com.brumethon.app.domain.session.SessionRepository;
import com.brumethon.kernel.SimpleService;
import com.brumethon.kernel.Validator;
import com.brumethon.kernel.exception.SimpleServiceObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SessionService extends SimpleService<SessionRepository, Session, String> {
    public SessionService(SessionRepository repository, Validator<Session> validator) {
        super(repository, validator, "session");
    }

    public Session getByUserID(UUID id){
        return repository.getByUserID(id).orElseThrow(() -> new SimpleServiceObjectNotFoundException("session", id.toString()));
    }

}
