package com.brumethon.app.infrastructure.service;

import com.brumethon.app.domain.session.Session;
import com.brumethon.app.domain.session.SessionRepository;
import com.brumethon.kernel.SimpleService;
import com.brumethon.kernel.Validator;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

public class SessionService extends SimpleService<SessionRepository, Session, String> {
    public SessionService(SessionRepository repository, Validator<Session> validator) {
        super(repository, validator, "session");
    }
}
