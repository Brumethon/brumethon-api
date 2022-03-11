package com.brumethon.app.domain.session;

import com.brumethon.kernel.Repository;

@org.springframework.stereotype.Repository
public interface SessionRepository extends Repository<Session, String> {
}
