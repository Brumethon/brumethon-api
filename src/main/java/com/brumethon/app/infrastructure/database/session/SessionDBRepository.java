package com.brumethon.app.infrastructure.database.session;

import org.springframework.data.repository.CrudRepository;

public interface SessionDBRepository extends CrudRepository<SessionDB, String> {
}
